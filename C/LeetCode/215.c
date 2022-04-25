#include <stdio.h>
#include <stdlib.h>

/* ������������ nums ������ k���뷵�������е� k ������Ԫ�ء�

��ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء� */


int Adjustheap(int *nums, int k, int h)
{   // ���� k ��Ԫ�ص�����λ�� С����
    int i = k, j = 2*k;
    int temp = nums[k];
    while (j<=h)
    {
        if (j<h && nums[j]>nums[j+1]) j++;
        if (temp>nums[j])  //��������temp�ȣ�������nums[i]
        {
            nums[i] = nums[j];
            i = j;
            j = 2*i;
        }
        else break;  // !!
    }
    nums[i] = temp;
}

int findKthLargest(int* nums, int numsSize, int k){
    int i;
    int dui[k+1];  //���±�� 1 ��ʼ
    for (i = 0; i < k; i++) dui[i+1] = nums[i];
    for (i = k/2; i > 0; i--) Adjustheap(dui, i, k);
    for (i = k; i < numsSize; i++)
    {
        if (nums[i]>dui[1]) 
        {
            dui[1] = nums[i];
            Adjustdui(dui, 1, k);
        }
    }
    return dui[1];
}


int main(int argc, char const *argv[])
{
    int nums[] = {3,2,3,1,2,4,5,5,6};
    int numsSize = sizeof(nums)/sizeof(int);
    int n = findKthLargest(nums, numsSize, 4);
    printf("%d ",n);
    return 0;
}
