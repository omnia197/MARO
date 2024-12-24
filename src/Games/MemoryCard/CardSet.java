package Games.MemoryCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CardSet {
    private final MemoryVariables variables;
    private final String[] cardList = {
            "darkness", "double", "fairy", "fighting", "fire", "grass",
            "lightning", "metal", "psychic", "water"
    };

    public CardSet(MemoryVariables variables) {
        this.variables = variables;
        setUp();
        shuffleCards();
    }

    public void setUp() {
        variables.cardSet.clear();
        for (String cardName : cardList) {
            try {
                String imagePath = "/media/MemoryCard/" + cardName + ".jpg";
                Image cardImg = new ImageIcon(getClass().getResource(imagePath)).getImage();
                if (cardImg != null) {
                    ImageIcon cardImageIcon = new ImageIcon(cardImg.getScaledInstance(90, 120, Image.SCALE_SMOOTH));
                    variables.cardSet.add(new Card(cardName, cardImageIcon));
                } else {
                    System.err.println("Failed to load image: " + imagePath);
                }
            } catch (Exception e) {
                System.err.println("Error loading image for " + cardName + ": " + e.getMessage());
            }
        }

        ArrayList<Card> duplicates = new ArrayList<>(variables.cardSet);
        variables.cardSet.addAll(duplicates);
    }
    public void shuffleCards() {
        for (int i = 0; i < variables.cardSet.size(); i++) {
            int j = (int) (Math.random() * variables.cardSet.size());
            Card temp = variables.cardSet.get(i);
            variables.cardSet.set(i, variables.cardSet.get(j));
            variables.cardSet.set(j, temp);
        }
    }
}