package gy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 最小生成树 {
	public static int n,p;
	public static int map[][];
	public static int max=Integer.MAX_VALUE;
	public static int index;
	public static void prim() {
		p=0;
		int path[]=new int[n];
		Queue<Integer> s=new LinkedList<>();
		s.add(0);
		path[0]=1;
		while(s.size()!=n) {
			int min=max;
			index=-1;
			for(Integer a:s) {
				for(int i=0;i<n;i++) {
					if(map[a][i]!=max&&path[i]!=1&&map[a][i]<min) {
						min=map[a][i];
						index=i;
					}
				}
			}
			if(index==-1) {
				index=0;
				break;
			}
			s.add(index);
			path[index]=1;
			p+=min;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			n=sc.nextInt();//节点的个数
			int m=sc.nextInt();//相连边的个数
			map=new int[n][n];
			for(int i=0;i<n;i++) {
				Arrays.fill(map[i], Integer.MAX_VALUE);
			}
			for(int i=0;i<m;i++) {
				int x=sc.nextInt()-1;
				int y=sc.nextInt()-1;
				int v=sc.nextInt();//权值>0
				if(map[x][y]>v||map[y][x]>v) {
					map[x][y]=v;
					map[y][x]=v;
				}else {
					continue;
				}
			}
			prim();
			if(index==0) {
				System.out.println("不连通");
			}else {
				System.out.println(p);
			}
		}
	}
}
