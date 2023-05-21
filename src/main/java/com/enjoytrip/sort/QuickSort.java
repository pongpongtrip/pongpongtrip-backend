package com.enjoytrip.sort;

import java.util.List;

import com.enjoytrip.ws.attraction.model.AttractionDetailDto;
import com.enjoytrip.ws.attraction.model.AttractionDto;

public class QuickSort {

    // pivot을 가장 맨 왼쪽 값을 pivot으로 잡았음
    public void pivotNaturalSort(List<AttractionDetailDto> attractionList, int low, int high) {
        if(low >= high) {
            return;
        }

        int pivot = naturalSort(attractionList, low, high);

        // pivot의 위치는 확정이 된 상태이기 때문에 제외하고 서로 반 나누어 다시 정렬
        pivotNaturalSort(attractionList, low, pivot - 1);
        pivotNaturalSort(attractionList, pivot + 1, high);
    }

    public int naturalSort(List<AttractionDetailDto> arr, int low, int high) {
        int left = low;
        int right = high;
        String pivot = arr.get(low).getTitle();

        while(left < right) { 
//        	System.out.println(pivot);
            while(left < right && arr.get(right).getTitle().compareTo(pivot) >= 0) {
                right--;
            }
            while(left < right && arr.get(left).getTitle().compareTo(pivot) <= 0) {
                left++;
            }
            // pivot기준 왼쪽에선 피벗보다 큰값을 찾고
            // 오른쪽에선 피벗보다 작은 값을 찾아서 swap
            swap(arr, left, right);
        }
        // left와 right가 만나서 끝난경우 pivot과 swap해준다
        swap(arr, low, left);
        
        // pivot 위치 리턴
        return left;
    }

    public void swap(List<AttractionDetailDto> arr, int a, int b) {
    	AttractionDetailDto temp = arr.get(a);
        // arr[a] = arr[b];
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }
}