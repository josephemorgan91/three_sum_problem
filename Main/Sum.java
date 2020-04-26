package Main;

import java.util.HashMap;
import java.util.Map;

public class Sum{
    public static int[] threeSum(int[] a, int sum) {
		Map<Integer, Integer> m = new HashMap<>();
		m.put(0, a[0]);
		for (int i = 1; i < a.length - 1; ++i) {
		    for (int j = (i + 1); j < a.length; ++j) {
		        if (m.containsValue(sum - a[i] - a [j])) {
		        	return new int[] {(sum - a[i] - a[j]), a[i], a[j]};
				}
			}
		    m.put(i, a[i]);
		}
		return null;
	}

	public static int[] threeSumQuadratic(int[] a, int sum){
		int x, y, z, start, end;
		Sort.MergeSort(a);
		for (int i = 0; i < a.length - 1; ++i) {
		    x = a[i];
		    start = i + 1;
		    end = a.length - 1;
		    while (start < end) {
		    	y = a[start];
		    	z = a[end];
		    	if ((x + y + z) == sum) {
		    	    return new int[] {x, y, z};
				} else if ((x + y + z) > sum) {
		    		--end;
				} else {
		    		++start;
				}
			}
		}
		return null;
	}
}