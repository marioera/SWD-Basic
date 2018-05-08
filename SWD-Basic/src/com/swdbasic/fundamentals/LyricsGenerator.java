package com.swdbasic.fundamentals;

public class LyricsGenerator {

	public static void main(String[] args) {
		String[] persons = {"Mami", "Gata", "Perra", "Zorra", "Chica"};
		String[] actions = {"yo quiero", "vamos a", "yo voy a", "yo quiero", "yo vengo a"};
		String[] verbs = {"castigarte", "cogerte", "encenderte", "darte", "azotarte"};
		String[] adverbs = {"duro", "rápido", "lento", "suave", "fuerte"};
		String[] timeFrame = {"hasta que salga el sol", "toda la noche", "hasta el amanecer", "hasta mañana", "todo el día"};
		String[] complements = {"sin miedo", "sin anestesia", "contra el piso", "contra la pared", "sin compromiso"};
		
		int personsLength = persons.length;
		int actionsLength = actions.length;
		int verbsLength = verbs.length;
		int adverbsLength = adverbs.length;
		int timeFrameLength = timeFrame.length;
		int complementsLength = complements.length;
		
		int rand1 = (int) (Math.random() * personsLength);
		int rand2 = (int) (Math.random() * actionsLength);
		int rand3 = (int) (Math.random() * verbsLength);
		int rand4 = (int) (Math.random() * adverbsLength);
		int rand5 = (int) (Math.random() * timeFrameLength);
		int rand6 = (int) (Math.random() * complementsLength);
		
		String songLyrics = persons[rand1] + " " + actions[rand2] + " " + verbs[rand3] + " " + adverbs[rand4] + " " + timeFrame[rand5] + " " + complements[rand6];
		
		System.out.println(songLyrics);

	}

}
