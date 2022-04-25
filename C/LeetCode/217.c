#include <stdio.h>
#include <stdlib.h>

//����������Ƿ�����ظ�Ԫ��

void containsDuplicate_1();//���ÿ���������飬 �����������ԭʼ��������ʱ��ʱ�� ��������ʱ����ʱ�临�Ӷȴﵽ���Ϊn2;

void containsDuplicate_2();//����ð��������飬 ͨ��;

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

void containsDuplicate_1()
{
    int nums[] = {1,5,-2,4,0};
    int numsSize = sizeof(nums)/sizeof(int);
    int flag = 0;
    flag = Qsort(nums, 0, numsSize, flag);
    for(int i=0; i<numsSize-1; i++)
        if(nums[i]==nums[i+1]) flag = 1;
    if (flag) printf ("true");
    else printf("false");
}



int BubbleSort(int *a, int n)
{
	int i, j, temp;
    int flag=1;
	for (i = 0; i < n; ++i)
    {
        flag=0;
		for (j = 0; j < n-i-1; ++j)
        {
            if(a[j]==a[j+1]) return 1;
			if (a[j]>a[j+1])
			{
                flag=1;
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
        }
        if(!flag) return 0;
    }
    return 0;
}

void containsDuplicate_2()
{
    int nums[] = {1,5,-2,4,1};
    int numsSize = sizeof(nums)/sizeof(int);
    int flag = 0;
    flag = BubbleSort(nums, numsSize);
    for(int i=0; i<numsSize-1; i++)
        if(nums[i]==nums[i+1]) flag = 1;
    if (flag) printf ("true");
    else printf("false");
}   

int main()
{
    containsDuplicate_2();
    return 0;
}