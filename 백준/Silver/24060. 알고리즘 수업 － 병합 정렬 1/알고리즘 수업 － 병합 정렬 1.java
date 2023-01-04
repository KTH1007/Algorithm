import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] temp;
	static int result = -1;
	static int count = 0;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		temp = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		MergeSort(arr, 0, arr.length-1);
		System.out.println(result);
	}
	public static void MergeSort(int[] arr, int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			MergeSort(arr, low, mid);
			MergeSort(arr, mid +1, high);
			merge(arr, low, mid, high);
		}
	}
	public static void merge(int[] arr, int low, int mid, int high) {
		int i = low;
		int j = mid+1;
		int t = 0;
		while(i<=mid && j<= high) {
			if(arr[i] <= arr[j])
				temp[t++] = arr[i++];
			else
				temp[t++] = arr[j++];
		}
		while(i<=mid) 
			temp[t++] = arr[i++];
		while(j<=high)
			temp[t++] = arr[j++];
		i = low;
		t = 0;
		while(i<=high) {
			count++;
			if(count == k) {
				result = temp[t];
				break;
			}
			arr[i++] = temp[t++];
		}
		
	}
}