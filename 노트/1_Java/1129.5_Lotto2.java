// 로또번호 6개를 뽑아 int배열에 넣으세요
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
					}// if - temp랑 같은게 앞에 있으면 for문을 빠져나가.
				}// for- 앞에 중복확인
			}while(i!=j);
			lotto[i] = temp;
		}// for - 난수를 lotto배열에
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







