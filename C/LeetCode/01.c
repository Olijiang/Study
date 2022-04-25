#include <stdio.h>
#include <stdlib.h>

//����������Ƿ�����ظ�Ԫ��

void containsDuplicate();//���ÿ���������飬 �����������ԭʼ��������ʱ��ʱ�� ��������ʱ����ʱ�临�Ӷȴﵽ���Ϊn2;

int Qsort(int* nums, int L, int H, int flag)
{
    if(L>=H) return 0;
    if (flag) return 0;
    
    int i=L, j=H;
    int temp = nums[L];
    while(i<j)
    {
        
        while(i<j && nums[j]>=temp)
        {
            if (nums[j]==temp) 
            {
                flag = 1;
                return 0;
            }
            j--;
        } 
        nums[i] = nums[j];
        while(i<j && nums[i]<temp) i++;
        nums[j] = nums[i];
    }
    nums[i] = temp;
    Qsort(nums, L, i-1, flag);
    Qsort(nums, i+1, H, flag);
    return flag;
}

void containsDuplicate()
{
    int nums[] = {1,5,-2,4,0};
    int numsSize = sizeof(nums)/sizeof(int);
    int flag = 0;
    flag = Qsort(nums, 0, numsSize, flag);
    if (flag) printf ("true");
    else printf("false");
}


int main()
{
    containsDuplicate();
    return 0;
}