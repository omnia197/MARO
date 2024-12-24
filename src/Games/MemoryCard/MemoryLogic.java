package Games.MemoryCard;

import javax.swing.*;

public class MemoryLogic {
    private final MemoryVariables variables;
    private Timer hideTimer;

    public MemoryLogic(MemoryVariables variables) {
        this.variables = variables;
        setupTimer();
    }

    private void setupTimer() {
        hideTimer = new Timer(1500, e -> hideCards());
        hideTimer.setRepeats(false);
    }

    public void handleCardClick(JButton clickedButton, int index) {
        if (!variables.gameReady || clickedButton == variables.card1Selected
                || clickedButton == variables.card2Selected) {
            return;
        }

        if (variables.card1Selected == null) {
            handleFirstCard(clickedButton, index);
        } else if (variables.card2Selected == null) {
            handleSecondCard(clickedButton, index);
        }
    }

    private void handleFirstCard(JButton clickedButton, int index) {
        variables.card1Selected = clickedButton;
        showCard(clickedButton, index);
    }

    private void handleSecondCard(JButton clickedButton, int index) {
        variables.card2Selected = clickedButton;
        showCard(clickedButton, index);

        if (!isMatch()) {
            variables.errorCount++;
            variables.errorLabel.setText("Errors: " + variables.errorCount);
            hideTimer.start();
        } else {
            variables.card1Selected = null;
            variables.card2Selected = null;
        }
    }

    private boolean isMatch() {
        int index1 = variables.buttons.indexOf(variables.card1Selected);
        int index2 = variables.buttons.indexOf(variables.card2Selected);
        return variables.cardSet.get(index1).getCardName()
                .equals(variables.cardSet.get(index2).getCardName());
    }

    private void showCard(JButton button, int index) {
        button.setIcon(variables.cardSet.get(index).getCardImageIcon());
    }

    private void hideCards() {
        if (variables.card1Selected != null && variables.card2Selected != null) {
            variables.card1Selected.setIcon(variables.cardBackIcon);
            variables.card2Selected.setIcon(variables.cardBackIcon);
            variables.card1Selected = null;
            variables.card2Selected = null;
        }
    }
}
