package samsung.last;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ArrayAndOP_17140 {
	static int x, y, val, time, rn, cn;
	static int [][] map;
	static int [] cnt;

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);

		x = sc.nextInt();
		y = sc.nextInt();
		val = sc.nextInt();
		
		rn = 3;
		cn = 3;
		time = 0;
		
		map = new int[201][201];
		
		for(int i=1 ; i<=3 ; i++)
			for(int j=1 ; j<=3 ; j++)
				map[i][j] = sc.nextInt();
	
		
		while(map[x][y] != val) {
			if(rn >= cn)
				cn = row();
			else 
				rn = col();
			
			time++;		
			if(time > 100) {
				time = -1;
				break;
			}
		}

		System.out.println(time);
		sc.close();
	}
	
	public static int row() {
		int c = 2;
		
		for(int i=1 ; i<=rn ; i++) {
			cnt = new int[101];
			
			for(int j=1 ; j<=cn ; j++) {
				cnt[map[i][j]]++;
			}
			
			PriorityQueue<Item> q = sort();
			
			int k=1;
			while(!q.isEmpty()) {
				Item item = q.poll();
				map[i][k] = item.n;
				map[i][k+1] = item.cnt;
				k += 2;
				
				if(k>100) break;
			}
			
			for(int j=k ; j<201; j++) //
				map[i][j] = 0;
			
			if(c < k-1) //최대 길이 설정
				c = k-1;
		}
		
		return c;
	}
	
	public static int col() {
		int c = 2;
		
		for(int i=1 ; i<= cn ; i++) {
			cnt = new int[101];
			
			for(int j=1 ; j<=rn ; j++) {
				cnt[map[j][i]]++;
			}
			
			PriorityQueue<Item> q = sort();
			
			int k=1;
			while(!q.isEmpty()) {
				Item item = q.poll();
				map[k][i] = item.n;
				map[k+1][i] = item.cnt;
				k += 2;
				
				if(k>100) break;
			}
			
			for(int j=k ; j<201; j++)
				map[j][i] = 0;
			
			if(c < k-1)
				c = k-1;
		}
		
		return c;
	}
	
	static PriorityQueue<Item> sort() {
	    PriorityQueue<Item> q = new PriorityQueue<Item>(new ComparatorSort());
	    for (int i = 1; i <= 100; i++) {
	      if (cnt[i] > 0) {
	        q.add(new Item(i, cnt[i]));
	      }
	    }
	    return q;
	  }
}

class ComparatorSort implements Comparator<Item> {
    public int compare(Item i1, Item i2) {
      if (i1.cnt < i2.cnt) {
        return -1;
      } else if (i1.cnt == i2.cnt) {
        if (i1.n < i2.n) {
          return -1;
        } else {
          return 1;
        }
      } else {
        return 1;
      }
    }
  }

class Item {
	int n; int cnt;
	Item(int n, int cnt) {
		this.n = n; this.cnt = cnt;
	}	
}
