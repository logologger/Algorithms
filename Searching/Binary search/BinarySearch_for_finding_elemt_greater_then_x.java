public static int binarySearch(List<Integer> arr,int x){

//Binary Search for finding element in the array such that difference between arr[]-x is minimum

		int l=0;
		int result=-1;
		int r=arr.size()-1;
		while(l<=r){
			int m=(l+r)/2;

			if(arr.get(m)<x){
				l=m+1;

			}
			else if(arr.get(m)>x){
				r=m-1;
				result=arr.get(m);
			}
			else{

				l=l+1;//increase l by 1 if element is equal


			}
		}
		return result;

	}
