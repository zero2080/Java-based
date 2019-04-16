// �ζǹ�ȣ 6���� �̾� int�迭�� ��������
//0.0 <= Math.random() < 1
//0.0 <= Math.random() *10 <10
//0.0 <= Math.random() *45 <45
//0 <= (int)(Math.random() *10)< 10
//0 <= (int)(Math.random()*45) < 45
//1 <= (int)(Math.random()*45)+1<46

public class Lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		int temp;
		int i, j;
		for(i=0 ; i<lotto.length ; i++) {
			do {
				temp = (int)(Math.random()*45)+1;
				for(j=0 ; j<i ; j++) {
					if(lotto[j] == temp) {
						break;
					}// if - temp�� ������ �տ� ������ for���� ��������.
				}// for- �տ� �ߺ�Ȯ��
			}while(i!=j);
			lotto[i] = temp;
		}// for - ������ lotto�迭��
		for(i=0 ; i<lotto.length ; i++) {
			for(j=i+1 ; j<lotto.length ; j++) {
				if(lotto[i]>lotto[j]) {
					temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}// sort
		for(int lo : lotto)
			System.out.print(lo + "\t");
	}
}







