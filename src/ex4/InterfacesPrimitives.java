package ex4;

import java.util.function.*;

public class InterfacesPrimitives {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// IntPredicate - évite le boxing/unboxing
		IntPredicate estPair = n -> n % 2 == 0;
		System.out.println("5 est pair: " + estPair.test(5));
		System.out.println("6 est pair: " + estPair.test(6));

		// IntConsumer
		IntConsumer afficheur = n -> System.out.println("Nombre: " + n);
		afficheur.accept(42);

		// IntFunction<R>
		IntFunction<String> convertisseur = n -> "Valeur: " + n;
		System.out.println(convertisseur.apply(100));

		// IntSupplier
		IntSupplier de = () -> (int) (Math.random() * 6) + 1;
		System.out.println("Lancer de dé: " + de.getAsInt());
	}

}
