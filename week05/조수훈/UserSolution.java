

import java.util.*;
import java.util.Map.Entry;

class UserSolution {
	
	int [] dx = {0,1,1,1,0,-1,-1,-1};
	int [] dy = {1,1,0,-1,-1,-1,0,1};
	
	int N;
	String [][] map;
	HashMap<String, int[]>  stringMap;
	HashMap<String, String> parent;
	HashMap<String, Set> enemy;
	int[][] soldiers;
	
    void init(int N, int mSoldier[][], char mMonarch[][][])
    {
    	this.N = N;
    	map = new String[N][N];
    	stringMap = new HashMap<>();
        parent = new HashMap<>();
        enemy = new HashMap<>();
        soldiers =new int[N][N];
        for(int i =0;i < N; i++) {
        	for(int j = 0;j< N; j++) {
        		parent.put(String.valueOf(mMonarch[i][j]).trim(),String.valueOf(mMonarch[i][j]).trim()) ;
        		soldiers[i][j] = mSoldier[i][j];
        		stringMap.put(String.valueOf(mMonarch[i][j]).trim(), new int[] {i,j});
        		enemy.put(String.valueOf(mMonarch[i][j]).trim(), new HashSet<String>());
        		map[i][j] = String.valueOf(mMonarch[i][j]).trim();
        	}
        } 
    }
    
    void destroy()
    {

    }
    
    void union(String A, String B) {
    	String a = find(A);
    	String b = find(B);
    	if(a.equals(b)) {
    		return;
    	}
    	if(a.compareTo(b)< 0 ) {
    		parent.put(b, a);
    	
    		
    	}else {
    		parent.put(a, b);
    	
    	}
    	
    }
    
    
    private String find(String a) {
		
    	if(parent.get(a).equals(a)) {
    		return a;
    	}
    	parent.put(a,find(parent.get(a)));
		return parent.get(a);
	}

	int ally(char mMonarchA[], char mMonarchB[])
    {
    	String MonarchA = String.valueOf(mMonarchA).trim();
    	String MonarchB = String.valueOf(mMonarchB).trim();
    	
    	String parentA = find(MonarchA);
    	String parentB = find(MonarchB);
    	
    	//이미 동맹 관계면 return -1
    	if( parentA.equals(parentB)) {
    		return -1;
    	}
    	//군주 mMonarchA 의 동맹과 군주 mMonarchB 의 동맹 간에 적대관계가 있으면 -2를 반환한다.
    	if( enemy.get(parentA).contains(parentB)) {
    		return -2;
    	}

    	//위의 두 경우가 아닌 경우 동맹 관계가 맺어지고, 1을 반환한다
    	union(MonarchA, MonarchB);
    	find(MonarchA);
    	find(MonarchB);
    	System.out.println("동맹관계");
    	for(Entry<String, String> t : parent.entrySet()) {
    		if(t.getValue().equals(parentB) || t.getValue().equals(parentA)) {
    			System.out.print(t.getKey()+" ");
    		}
    	}
    
        return 1;
    }


	int attack(char mMonarchA[], char mMonarchB[], char mGeneral[])
    {
		// 군주 mMonarchA 와 군주 mMonarchB 가 동맹관계 이면 -1을 반환하고, 전투는 일어나지 않는다.
		String parentA = find(String.valueOf(mMonarchA).trim());
		String parentB = find(String.valueOf(mMonarchB).trim());
		if(parentA.equals(parentB)) return -1;
		//군주 mMonarchA 의 영토 또는 동맹 영토가 군주 mMonarchB 의 영토와 인접하지 않다면 -2을 반환하고, 전투는 일어나지 않는다.
		int [] b = stringMap.get(String.valueOf(mMonarchB).trim());
		boolean flag = false;
		for(int i =0;i < 8 ;i++) {
			int nx = dx[i] + b[0];
			int ny = dy[i] + b[1];
			if(nx >= N || nx < 0 || ny >= N || ny <0) {
				continue;
			}
			String tempMonarch = map[nx][ny];
			if(find(tempMonarch).equals(parentA)) {
				flag = true;
			}		
		}
		if(flag == false) {
			return -2;
		}
		
		//전투가 발생하면 군주 mMonarchA 의 동맹과 군주 mMonarchB 의 동맹은 서로 적대관계가 된다.
		enemy.get(parentA).add(parentB);
		enemy.get(parentB).add(parentA);
//		System.out.println(enemy.toString());
		
		//전투가 발생하면 군주 mMonarchB 의 영토에 인접한 군주 mMonarchA 를 포함한 모든 동맹들은 보유한 병사의 절반을 보내 함께 공격한다.
		for(int i =0;i < 8 ;i++) {
			int nx = dx[i] + b[0];
			int ny = dy[i] + b[1];
			if(nx >= N || nx < 0 || ny >= N || ny <0) {
				continue;
			}
			if(find(map[nx][ny]).equals(parentA)) {
				int temp = soldiers[nx][ny]/2;
				soldiers[nx][ny] -= temp;
				soldiers[b[0]][b[1]] -= temp;
			}
		}
		//군주 mMonarchB 의 영토에 인접한 군주 mMonarchB 의 모든 동맹들도 보유한 병사의 절반을 mMonarchB 의 영토로 보내 방어를 돕는다.
		for(int i =0;i < 8 ;i++) {
			int nx = dx[i] + b[0];
			int ny = dy[i] + b[1];
			if(nx >= N || nx < 0 || ny >= N || ny <0) {
				continue;
			}
			if(find(map[nx][ny]).equals(parentB)) {
//				System.out.println(parentB+" parentB "+soldiers[nx][ny]);
				int temp = soldiers[nx][ny]/2;
				soldiers[nx][ny] -= temp;
				soldiers[b[0]][b[1]] += temp;
			}
		}

//		공격하는 쪽의 병사가 남았다면, 공격 성공으로 1을 반환하고,
//		방어하는 쪽의 병사가 남았거나, 모든 병사가 사망한 경우 0을 반환한다.
		if(soldiers[b[0]][b[1]]>=0) {
			return 0;
		}else {
//			공격이 성공하면 군주 mMonarchB 는 처형되고,
//			mMonarchB 가 다스렸던 영토는 멸망하여 동맹관계도 적대관계도 없는 새로운 영토가 된다.
//			새로운 영토의 군주는 mGeneral 이 되고, mMonarchA의 동맹에 편입되며, 적대 관계는 mMonarchA 의 적대 관계와 동일하다.
			parent.put(String.valueOf(mGeneral).trim(),String.valueOf(mGeneral).trim()) ;
			union(String.valueOf(mGeneral).trim(), String.valueOf(mMonarchA).trim());
			soldiers[b[0]][b[1]] = -soldiers[b[0]][b[1]];
			stringMap.put(String.valueOf(String.valueOf(mGeneral).trim()), new int[] {b[0],b[1]});
			map[b[0]][b[1]] = String.valueOf(mGeneral).trim();
			enemy.get(parentA).remove(parentB);
			enemy.remove(parentB);
			enemy.put(String.valueOf(mGeneral).trim(), new HashSet<String>());
			return 1;
		}
		

    }
    int recruit(char mMonarch[], int mNum, int mOption)
    {
    	
//    	mOption 이 0 일 때,
//    	-………. 군주 mMonarch 의 영토에 mNum 명의 병사를 모집한다.
//    	-………. 병사 모집 이후에 군주 mMonarch 영토의 병사의 수를 반환한다.
    	if(mOption == 0  ) {
    		int [] t = stringMap.get(String.valueOf(mMonarch).trim());
    		soldiers[t[0]][t[1]] += mNum;
    		System.out.println(Arrays.deepToString(soldiers));
    		return soldiers[t[0]][t[1]];
    	}
    	
//    	mOption 이 1 일 때,
//    	-………. 군주 mMonarch 를 포함한 모든 동맹의 영토에 각각 mNum 명의 병사를 모집한다.
//    	-………. 병사 모집 이후에 군주 mMonarch 동맹의 모든 병사의 수 합산하여 반환한다.
    	if(mOption == 1  ) {
    		int r = 0;
    		for(Entry<String, String> t: parent.entrySet()) {
    			if(t.getValue().equals(find(String.valueOf(mMonarch).trim()))){
    				String m = t.getKey();
    				int [] k = stringMap.get(m);;
    				soldiers[k[0]][k[1]] += mNum;
    				r += soldiers[k[0]][k[1]];
    			}
    			
    		}
      		System.out.println(Arrays.deepToString(soldiers));
    		return r;
    	}
        return -1;
    }
}