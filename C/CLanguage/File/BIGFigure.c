#include <stdio.h>
#include <stdlib.h>

// �����׳ˣ�����ʵ��

int Muti(int n)
{
    int *nums = malloc(sizeof(int)*500);
    int k = 1;      //������Ч����
    int temp, up;   //upΪ��λ���
    nums[1] = 1;    //�� 1 ��ʼ
    for (int i = 1; i <= n; i++)
    {
        up=0;
        for (int j = 1; j <= k; j++)
        {
            temp = nums[j]*i + up;
            nums[j] = temp%10;
            up = temp/10;
        }
        while (up)
        {
            nums[++k] = up%10;  //���λ��λ,��Ч����+1
            up = up/10;
        }
    }
    for (int i = k; i > 0; i--)
        printf("%d",nums[i]);
}


int main()
{
    int n;
    printf("Number:");
    scanf("%d",&n);
    Muti(n);
    return 0;
}
