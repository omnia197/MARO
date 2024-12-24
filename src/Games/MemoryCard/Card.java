package Games.MemoryCard;

import javax.swing.ImageIcon;

public class Card {
    private String cardName;
    private ImageIcon cardImageIcon;

    public Card(String cardName, ImageIcon cardImageIcon) {
        this.cardName = cardName;
        this.cardImageIcon = cardImageIcon;
    }

    public String getCardName() { return cardName; }
    public ImageIcon getCardImageIcon() { return cardImageIcon; }
    public void setCardImageIcon(ImageIcon icon) { this.cardImageIcon = icon; }
}