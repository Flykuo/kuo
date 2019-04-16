package gy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 最短路 {
	public static int n,m;
	public static int map[][];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			n=sc.nextInt();
			m=sc.nextInt();
			map=new int[n][n];
			for(int i=0;i<n;i++) {
				Arrays.fill(map[i], 0x3f3f3f3f);
			}
			//构建邻接矩阵
			for(int i=0;i<m;i++) {
				int x=sc.nextInt()-1;
				int y=sc.nextInt()-1;
				int v=sc.nextInt();
				if(map[x][y]>v) {
					map[x][y]=v;
				}
			}
			int dis[]=new int[n];//
			int vis[]=new int[n];//标记数组
			//对dis[]初始化
			for(int i=0;i<n;i++) {
				dis[i]=map[0][i];
			}
			vis[0]=1;
			for(int i=0;i<n-1;i++) {
				int min=0x3f3f3f3f;
				int index=i;
				for(int j=0;j<n;j++) {
					if(vis[j]==0&&min>dis[j]) {
						index=j;
						min=dis[j];
					}
				}
				vis[index]=1;
				for(int j=0;j<n;j++) {
					if(vis[j]==0&&dis[j]>dis[index]+map[index][j]) {//如果这个点没有被遍历过并且这个点的
						dis[j]=dis[index]+map[index][j];
					}
				}
			}
			System.out.println(dis[n-1]);
		}
	}
}
