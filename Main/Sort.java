package Main;

public class Sort {
	public static void MergeSort(int[] a){
		if (a.length != 0) {
			mergeSortHelper(a, 0, a.length - 1);
		}
	}

	private static void mergeSortHelper(int[] a, int leftIndex, int rightIndex) {
		if (rightIndex > leftIndex) {
			int middle = (leftIndex + rightIndex) / 2;

			mergeSortHelper(a, leftIndex, middle);
			mergeSortHelper(a, middle + 1, rightIndex);
			mergeHalves(a, leftIndex, middle, rightIndex);
		}
	}

	private static void mergeHalves(int[] a, int leftIndex, int middleIndex, int rightIndex) {
	    int[] leftTempArray = new int[(middleIndex - leftIndex + 1)];
	    int[] rightTempArray = new int[(rightIndex - middleIndex)];

	    for (int i = 0; i < leftTempArray.length; ++i) {
	    	leftTempArray[i] = a[i + leftIndex];
		}
	    for (int i = 0; i < rightTempArray.length; ++i) {
	        rightTempArray[i] = a[i + (middleIndex + 1)];
		}

	    int mainArrayIndex = leftIndex;
	    int leftTempArrayIndex = 0;
	    int rightTempArrayIndex = 0;
	    while (leftTempArrayIndex < leftTempArray.length && rightTempArrayIndex < rightTempArray.length) {
	    	if (leftTempArray[leftTempArrayIndex] < rightTempArray[rightTempArrayIndex]) {
	    		a[mainArrayIndex++] = leftTempArray[leftTempArrayIndex++];
			} else {
	    		a[mainArrayIndex++] = rightTempArray[rightTempArrayIndex++];
			}
		}

	    while (leftTempArrayIndex < leftTempArray.length) {
	    	a[mainArrayIndex++] = leftTempArray[leftTempArrayIndex++];
		}

	    while (rightTempArrayIndex < rightTempArray.length) {
	    	a[mainArrayIndex++] = rightTempArray[rightTempArrayIndex++];
		}
	}
}