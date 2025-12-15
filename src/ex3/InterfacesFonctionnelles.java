package ex3;

import java.util.function.*;

public class InterfacesFonctionnelles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Predicate - teste une condition et retourne un booléen
        Predicate<String> estVide = s -> s.isEmpty();
        System.out.println("La chaîne est vide: " + estVide.test(""));
        System.out.println("La chaîne est vide: " + estVide.test("Bonjour"));
        
        // Consumer - accepte une entrée et ne retourne rien
        Consumer<String> afficheur = s -> System.out.println("Affichage: " + s);
        afficheur.accept("Bonjour le monde");
        
        // Function - transforme une entrée en une sortie
        Function<String, Integer> longueur = s -> s.length();
        System.out.println("Longueur: " + longueur.apply("Bonjour"));
        
        // Supplier - ne prend pas d'entrée mais fournit une sortie
        Supplier<Double> nombreAleatoire = () -> Math.random();
        System.out.println("Nombre aléatoire: " + 1+nombreAleatoire.get());
	}

}
