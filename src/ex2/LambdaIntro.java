package ex2;

public class LambdaIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculateur addition = new Calculateur() {

			@Override
			public int calcule(int a, int b) {
				// TODO Auto-generated method stub
				return a + b;
			}
		};
		Calculateur additionLambda = (a, b) -> a + b;
		System.out.println("Addition traditionnelle :" + addition.calcule(10, 55));
		System.out.println("Addition avec lambda :" + additionLambda.calcule(44, 6));

	}

}
