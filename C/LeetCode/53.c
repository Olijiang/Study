#include <stdio.h>
#include <stdlib.h>

// ����һ���������� nums ���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�

//����˼�룺




int maxSubArray(int* nums, int numsSize){
    int i, sum = 0;
    int max=nums[0]; 
    for (int i = 0; i < numsSize; i++)
    {

        sum+= nums[i];
        max = (max>sum)?max:sum;
        if (sum<0) sum=0;   //���sum < 0��sum�Ժ���Ĺ����Ǹ��ģ� ֱ����0��
    }
    return max;
}


int main(int argc, char const *argv[])
{
    int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
    int numsSize = sizeof(nums)/sizeof(int);
    printf("%d",maxSubArray(nums, numsSize)); 

    return 0;
}
