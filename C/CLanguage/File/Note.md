
## scanf ���밸��ѧϰ
    ����һ�ΰ����ݶ����뵽����������һ��scanf��ֱ�ӳ建������ȡ���ݣ�

int main()
{
    int t, n, k, sum, be;
    scanf("%d", &t);
    for (int i = 0; i < t; i++)
    {
        sum = 0;
        be = 1;
        scanf("%d", &n);
        for (int j = 0; j < n; j++)
        {
            scanf("%d",&k);
            sum += (be<k)?(6*(k-be)):(4*(be-k)); //�ʺű��ʽ��Ҫ�����������ʽ��������ң����ӳ���
            be = k;
        }
        printf("%d\n", sum+3*n);
    }
    return 0;
}   