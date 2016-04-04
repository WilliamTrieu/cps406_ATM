/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmthingy;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

/**
 *
 * @author HP USER
 */
public class ATM {

    //DECLARATION OF CLASS VARIABLES, PANELS AND FRAMES
    public static JPanel cards;
    public static JFrame startFrame;
    public static JPanel openingPanel;
    public static JPanel PINPanel;
    public static JPanel MainPanel;
    public static JPanel inquiryPanel;
    public static JPanel withdrawPanel;
    public static JPanel transferPanel;
    public static JPanel depositPanel;
    public static JPanel changePanel;
    public static JPanel activityPanel;
    public static JPanel summaryPanel;
    public static JPanel balancePanel;
    static final int XYDIMENSIONS = 525;
    public static JButton hello;
    public static String pinAttempt;
    public static JButton[] pin = new JButton[100];
    public static int PINCount;
    public static int depositAmount;
    public static int x = 0;
    public static User John_Doe;
    public static GridLayout gLayout;
    public static BorderLayout bLayout;
    //public static JButton hello2;

    public ATM() {
        //INSTANTIATION OF VARIABLES AND FRAMES
        PINCount = 0;
        pinAttempt = "";
        startFrame = new JFrame("ATM");
        John_Doe = new User();
        startFrame.setSize(XYDIMENSIONS, XYDIMENSIONS);
        startFrame.setVisible(true);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cards = new JPanel(new CardLayout());
        startFrame.add(cards);
        gLayout = new GridLayout(4, 6, 2, 0);
        bLayout = new BorderLayout();
        OpeningPanel();
        PINPanel();
        MainPanel();
        InquiryPanel();
        ActivityPanel();
        SummaryPanel(1);
        BalancePanel(1);
        WithdrawPanel();
        DepositPanel();
        TransferPanel();
        ChangePinPanel();
    }

    //CARD LAYOUT METHOD
    public void CardLayoutNext() {
        CardLayout c1 = (CardLayout) (cards.getLayout());
        c1.next(cards);
    }

    public void CardLayoutFirst() {
        CardLayout c1 = (CardLayout) (cards.getLayout());
        c1.first(cards);
    }

    public void CardLayoutPrevious() {
        CardLayout c1 = (CardLayout) (cards.getLayout());
        c1.previous(cards);
    }

    //EVERYTHING THAT HAS TO HAPPEN FOR THE INITIAL PANEL THE WELCOME PANEL
    public void OpeningPanel() {
        openingPanel = new WelcomePanel();
        openingPanel.setBackground(Color.green);
        cards.add(openingPanel);
        WelcomePanel.insert.addActionListener(new HelloAction());
        WelcomePanel.nfc.addActionListener(new HelloAction());
    }

    //ACTION LISTENER FOR HELLO BUTTON IN OPENING PANEL
    class HelloAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(WelcomePanel.insert)) {
                CardLayoutNext();
            } else {
                CardLayoutNext();
                CardLayoutNext();
            }

        }
    }

    //EVERYHTING THAT HAPPENS IN THE SECOND PANEL THE PIN PANEL
    public void PINPanel() {
        PINPanel = new PinPanel();
        PINPanel.setBackground(Color.green);
        cards.add(PINPanel);

        //DECLARATION AND INSTANTIATION OF ALL PIN BUTTONS
        PinPanel.back.addActionListener(new BackAction());
        PinPanel.b0.addActionListener(new PinAction());
        PinPanel.b1.addActionListener(new PinAction());
        PinPanel.b2.addActionListener(new PinAction());
        PinPanel.b3.addActionListener(new PinAction());
        PinPanel.b4.addActionListener(new PinAction());
        PinPanel.b5.addActionListener(new PinAction());
        PinPanel.b6.addActionListener(new PinAction());
        PinPanel.b7.addActionListener(new PinAction());
        PinPanel.b8.addActionListener(new PinAction());
        PinPanel.b9.addActionListener(new PinAction());
        PinPanel.enter.addActionListener(new PinAction());
        PinPanel.bx.addActionListener(new PinAction());

    }

    //ACTION LISTENER FOR PIN NUMBER BUTTONS IN THE PIN PANEL
    class PinAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(PinPanel.b0) && PINCount < 4) {
                PinPanel.pinAttempt.setText(PinPanel.pinAttempt.getText() + 0);
                PINCount++;
            }
            if (e.getSource().equals(PinPanel.b1) && PINCount < 4) {
                PinPanel.pinAttempt.setText(PinPanel.pinAttempt.getText() + 1);
                PINCount++;
            }
            if (e.getSource().equals(PinPanel.b2) && PINCount < 4) {
                PinPanel.pinAttempt.setText(PinPanel.pinAttempt.getText() + 2);
                PINCount++;
            }
            if (e.getSource().equals(PinPanel.b3) && PINCount < 4) {
                PinPanel.pinAttempt.setText(PinPanel.pinAttempt.getText() + 3);
                PINCount++;
            }
            if (e.getSource().equals(PinPanel.b4) && PINCount < 4) {
                PinPanel.pinAttempt.setText(PinPanel.pinAttempt.getText() + 4);
                PINCount++;
            }
            if (e.getSource().equals(PinPanel.b5) && PINCount < 4) {
                PinPanel.pinAttempt.setText(PinPanel.pinAttempt.getText() + 5);
                PINCount++;
            }
            if (e.getSource().equals(PinPanel.b6) && PINCount < 4) {
                PinPanel.pinAttempt.setText(PinPanel.pinAttempt.getText() + 6);
                PINCount++;
            }
            if (e.getSource().equals(PinPanel.b7) && PINCount < 4) {
                PinPanel.pinAttempt.setText(PinPanel.pinAttempt.getText() + 7);
                PINCount++;
            }
            if (e.getSource().equals(PinPanel.b8) && PINCount < 4) {
                PinPanel.pinAttempt.setText(PinPanel.pinAttempt.getText() + 8);
                PINCount++;
            }
            if (e.getSource().equals(PinPanel.b9) && PINCount < 4) {
                PinPanel.pinAttempt.setText(PinPanel.pinAttempt.getText() + 9);
                PINCount++;
            }
            if (e.getSource().equals(PinPanel.bx) && PINCount > 0) {
                pinAttempt = pinAttempt.substring(0, PinPanel.pinAttempt.getText().length() - 1);
                PinPanel.pinAttempt.setText(pinAttempt);
                System.out.println(pinAttempt);
                PINCount--;
            }
            if (e.getSource().equals(PinPanel.enter) && PINCount == 4) {
                if (PinPanel.pinAttempt.getText().equals(John_Doe.getPIN())) {
                    System.out.println("CORRECT PIN");
                    PinPanel.pinAttempt.setText("");
                    CardLayoutNext();
                } else {
                    PinPanel.error.setText("WRONG PIN");
                }
                pinAttempt = "";
                PINCount = 0;
            }
        }
    }

    public void MainPanel() {
        MainPanel = new MainJPanel();
        MainPanel.setBackground(Color.green);
        cards.add(MainPanel);
        MainJPanel.inquiry.addActionListener(new MainPanelAction());
        MainJPanel.withdraw.addActionListener(new MainPanelAction());
        MainJPanel.deposit.addActionListener(new MainPanelAction());
        MainJPanel.transfer.addActionListener(new MainPanelAction());
        MainJPanel.changePin.addActionListener(new MainPanelAction());
        MainJPanel.exit.addActionListener(new MainPanelAction());
    }

    class MainPanelAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(MainJPanel.inquiry)) {
                CardLayoutNext();
            }
            if (e.getSource().equals(InquiryPanel.activity)) {
                CardLayoutNext();
            }
            if (e.getSource().equals(InquiryPanel.summary)) {
                CardLayoutNext();
                CardLayoutNext();
            }
            if (e.getSource().equals(InquiryPanel.balance)) {
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
            }
            if (e.getSource().equals(MainJPanel.withdraw)) {
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
            }
            if (e.getSource().equals(MainJPanel.deposit)) {
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
            }
            if (e.getSource().equals(MainJPanel.transfer)) {
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
            }
            if (e.getSource().equals(MainJPanel.changePin)) {
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
                CardLayoutNext();
            }
            if (e.getSource().equals(MainJPanel.exit)) {
                CardLayoutFirst();
            }
        }

    }

    class BackAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(PinPanel.back)) {
                CardLayoutFirst();
            }
            if (e.getSource().equals(InquiryPanel.back)) {
                CardLayoutPrevious();
            }
            if (e.getSource().equals(ActivityPanel.back)) {
                CardLayoutPrevious();
            }
            if (e.getSource().equals(SummaryPanel.back)) {
                CardLayoutPrevious();
                CardLayoutPrevious();
            }
            if (e.getSource().equals(BalancePanel.back)) {
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
            }
            if (e.getSource().equals(WithdrawPanel.back)) {
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
            }
            if (e.getSource().equals(DepositPanel.back)) {
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
            }
            if (e.getSource().equals(TransferPanel.back)) {
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
            }
            if (e.getSource().equals(ChangePinPanel.back)) {
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
                CardLayoutPrevious();
            }
        }

    }

    public void InquiryPanel() {
        inquiryPanel = new InquiryPanel();
        inquiryPanel.setBackground(Color.green);
        cards.add(inquiryPanel);
        InquiryPanel.back.addActionListener(new BackAction());
        InquiryPanel.activity.addActionListener(new MainPanelAction());
        InquiryPanel.summary.addActionListener(new MainPanelAction());
        InquiryPanel.balance.addActionListener(new MainPanelAction());

    }

    public void ActivityPanel() {
        activityPanel = new ActivityPanel();
        activityPanel.setBackground(Color.green);
        cards.add(activityPanel);
        ActivityPanel.back.addActionListener(new BackAction());

    }

    public void SummaryPanel(int x) {
        if (x == 1) {
            summaryPanel = new SummaryPanel();
            summaryPanel.setBackground(Color.green);
            cards.add(summaryPanel);
            SummaryPanel.back.addActionListener(new BackAction());
        }
        SummaryPanel.name.setText("Name: " + John_Doe.getName());
        SummaryPanel.accNum.setText("Account Number: " + Integer.toString(John_Doe.getAccNum()));
        SummaryPanel.sBalance.setText("Savings Balance: $" + Double.toString(John_Doe.getSaving()));
        SummaryPanel.cBalance.setText("Checking Balance $" + Double.toString(John_Doe.getChecking()));

    }

    public void BalancePanel(int x) {
        if (x == 1) {
            balancePanel = new BalancePanel();
            balancePanel.setBackground(Color.green);
            cards.add(balancePanel);
            BalancePanel.back.addActionListener(new BackAction());
        }
        BalancePanel.checking.setText("$" + Double.toString(John_Doe.getChecking()));
        BalancePanel.savings.setText("$" + Double.toString(John_Doe.getSaving()));
    }

    public void WithdrawPanel() {
        withdrawPanel = new WithdrawPanel();
        withdrawPanel.setBackground(Color.green);
        cards.add(withdrawPanel);
        WithdrawPanel.back.addActionListener(new BackAction());
        WithdrawPanel.b20.addActionListener(new WithdrawAction());
        WithdrawPanel.b40.addActionListener(new WithdrawAction());
        WithdrawPanel.b60.addActionListener(new WithdrawAction());
        WithdrawPanel.b80.addActionListener(new WithdrawAction());
        WithdrawPanel.b100.addActionListener(new WithdrawAction());
        WithdrawPanel.b200.addActionListener(new WithdrawAction());

    }

    class WithdrawAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(WithdrawPanel.b20)) {
                if (John_Doe.withdrawChecking(20)) {
                    WithdrawPanel.error.setText("");
                    SummaryPanel(0);
                    BalancePanel(0);
                    addActivity("$20 Withdrawn");
                } else {
                    WithdrawPanel.error.setText("INSUFFICIENT FUNDS");
                }
            }
            if (e.getSource().equals(WithdrawPanel.b40)) {
                if (John_Doe.withdrawChecking(40)) {
                    WithdrawPanel.error.setText("");
                    addActivity("$40 Withdrawn");
                    SummaryPanel(0);
                    BalancePanel(0);
                } else {
                    WithdrawPanel.error.setText("INSUFFICIENT FUNDS");
                }

            }
            if (e.getSource().equals(WithdrawPanel.b60)) {
                if (John_Doe.withdrawChecking(60)) {
                    WithdrawPanel.error.setText("");
                    SummaryPanel(0);
                    BalancePanel(0);
                    addActivity("$60 Withdrawn");
                } else {
                    WithdrawPanel.error.setText("INSUFFICIENT FUNDS");
                }

            }
            if (e.getSource().equals(WithdrawPanel.b80)) {
                if (John_Doe.withdrawChecking(80)) {
                    WithdrawPanel.error.setText("");
                    SummaryPanel(0);
                    BalancePanel(0);
                    addActivity("$80 Withdrawn");
                } else {
                    WithdrawPanel.error.setText("INSUFFICIENT FUNDS");
                }

            }
            if (e.getSource().equals(WithdrawPanel.b100)) {
                if (John_Doe.withdrawChecking(100)) {
                    WithdrawPanel.error.setText("");
                    SummaryPanel(0);
                    BalancePanel(0);
                    addActivity("$100 Withdrawn");
                } else {
                    WithdrawPanel.error.setText("INSUFFICIENT FUNDS");
                }

            }
            if (e.getSource().equals(WithdrawPanel.b200)) {
                if (John_Doe.withdrawChecking(200)) {
                    WithdrawPanel.error.setText("");
                    SummaryPanel(0);
                    BalancePanel(0);
                    addActivity("$200 Withdrawn");
                } else {
                    WithdrawPanel.error.setText("INSUFFICIENT FUNDS");
                }

            }
            System.out.println(John_Doe.getChecking());
        }

        public void addActivity(String activity) {
            int x = ActivityPanel.j.length;
            for (int i = 9; i > 0; i--) {
                if (!ActivityPanel.j[i - 1].getText().equals("")) {
                    ActivityPanel.j[i].setText(ActivityPanel.j[i - 1].getText());
                }
            }
            ActivityPanel.j[0].setText(activity);

        }
    }

    class DepositNumPadAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String y = DepositPanel.amount.getText();
            int x = y.length() - 1;
            if (e.getSource().equals(DepositPanel.b0)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        DepositPanel.amount.setText(DepositPanel.amount.getText() + 0);
                    }
                } else {
                    DepositPanel.amount.setText(DepositPanel.amount.getText() + 0);
                }
            }
            if (e.getSource().equals(DepositPanel.b1)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        DepositPanel.amount.setText(DepositPanel.amount.getText() + 1);
                    }
                } else {
                    DepositPanel.amount.setText(DepositPanel.amount.getText() + 1);
                }
            }
            if (e.getSource().equals(DepositPanel.b2)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        DepositPanel.amount.setText(DepositPanel.amount.getText() + 2);
                    }
                } else {
                    DepositPanel.amount.setText(DepositPanel.amount.getText() + 2);
                }
            }
            if (e.getSource().equals(DepositPanel.b3)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        DepositPanel.amount.setText(DepositPanel.amount.getText() + 3);
                    }
                } else {
                    DepositPanel.amount.setText(DepositPanel.amount.getText() + 3);
                }
            }
            if (e.getSource().equals(DepositPanel.b4)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        DepositPanel.amount.setText(DepositPanel.amount.getText() + 4);
                    }
                } else {
                    DepositPanel.amount.setText(DepositPanel.amount.getText() + 4);
                }
            }
            if (e.getSource().equals(DepositPanel.b5)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        DepositPanel.amount.setText(DepositPanel.amount.getText() + 5);
                    }
                } else {
                    DepositPanel.amount.setText(DepositPanel.amount.getText() + 5);
                }
            }
            if (e.getSource().equals(DepositPanel.b6)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        DepositPanel.amount.setText(DepositPanel.amount.getText() + 6);
                    }
                } else {
                    DepositPanel.amount.setText(DepositPanel.amount.getText() + 6);
                }
            }
            if (e.getSource().equals(DepositPanel.b7)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        DepositPanel.amount.setText(DepositPanel.amount.getText() + 7);
                    }
                } else {
                    DepositPanel.amount.setText(DepositPanel.amount.getText() + 7);
                }
            }
            if (e.getSource().equals(DepositPanel.b8)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        DepositPanel.amount.setText(DepositPanel.amount.getText() + 8);
                    }
                } else {
                    DepositPanel.amount.setText(DepositPanel.amount.getText() + 8);
                }
            }
            if (e.getSource().equals(DepositPanel.b9)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        DepositPanel.amount.setText(DepositPanel.amount.getText() + 9);
                    }
                } else {
                    DepositPanel.amount.setText(DepositPanel.amount.getText() + 9);
                }
            }
            if (e.getSource().equals(DepositPanel.bdecimal)) {
                if (!y.contains(".")) {
                    DepositPanel.amount.setText(DepositPanel.amount.getText() + ".");
                }
            }
            if (e.getSource().equals(DepositPanel.bx)) {
                if (y.length() > 0) {
                    try {
                        DepositPanel.amount.setText(DepositPanel.amount.getText(0, x));
                    } catch (BadLocationException ex) {
                        Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            if (e.getSource().equals(DepositPanel.deposit)) {
                if (y.length() > 0) {
                    if (DepositPanel.dropdown.getSelectedIndex() == 0) {
                        System.out.println("SAVINGS");
                        John_Doe.depositSaving(Double.parseDouble(y));
                        System.out.println(John_Doe.getSaving());
                        SummaryPanel(0);
                        BalancePanel(0);
                        addActivity("$" + y + " Deposited in Savings");

                    } else {
                        System.out.println("CHECKINGS");
                        John_Doe.depositChecking(Double.parseDouble(y));
                        System.out.println(John_Doe.getChecking());
                        SummaryPanel(0);
                        BalancePanel(0);
                        addActivity("$" + y + " Deposited in Checkings");
                    }
                    DepositPanel.amount.setText("");
                }
            }
        }

        public void addActivity(String activity) {
            int x = ActivityPanel.j.length;
            for (int i = 9; i > 0; i--) {
                if (!ActivityPanel.j[i - 1].getText().equals("")) {
                    ActivityPanel.j[i].setText(ActivityPanel.j[i - 1].getText());
                }
            }
            ActivityPanel.j[0].setText(activity);

        }
    }

    public void DepositPanel() {
        depositPanel = new DepositPanel();
        depositPanel.setBackground(Color.green);
        cards.add(depositPanel);
        DepositPanel.back.addActionListener(new BackAction());
        DepositPanel.b0.addActionListener(new DepositNumPadAction());
        DepositPanel.b1.addActionListener(new DepositNumPadAction());
        DepositPanel.b2.addActionListener(new DepositNumPadAction());
        DepositPanel.b3.addActionListener(new DepositNumPadAction());
        DepositPanel.b4.addActionListener(new DepositNumPadAction());
        DepositPanel.b5.addActionListener(new DepositNumPadAction());
        DepositPanel.b6.addActionListener(new DepositNumPadAction());
        DepositPanel.b7.addActionListener(new DepositNumPadAction());
        DepositPanel.b8.addActionListener(new DepositNumPadAction());
        DepositPanel.b9.addActionListener(new DepositNumPadAction());
        DepositPanel.bdecimal.addActionListener(new DepositNumPadAction());
        DepositPanel.bx.addActionListener(new DepositNumPadAction());
        DepositPanel.deposit.addActionListener(new DepositNumPadAction());
    }

    class TransferAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String y = TransferPanel.amount.getText();
            int x = y.length() - 1;
            if (e.getSource().equals(TransferPanel.b0)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        TransferPanel.amount.setText(TransferPanel.amount.getText() + 0);
                    }
                } else {
                    TransferPanel.amount.setText(TransferPanel.amount.getText() + 0);
                }
            }
            if (e.getSource().equals(TransferPanel.b1)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        TransferPanel.amount.setText(TransferPanel.amount.getText() + 1);
                    }
                } else {
                    TransferPanel.amount.setText(TransferPanel.amount.getText() + 1);
                }
            }
            if (e.getSource().equals(TransferPanel.b2)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        TransferPanel.amount.setText(TransferPanel.amount.getText() + 2);
                    }
                } else {
                    TransferPanel.amount.setText(TransferPanel.amount.getText() + 2);
                }
            }
            if (e.getSource().equals(TransferPanel.b3)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        TransferPanel.amount.setText(TransferPanel.amount.getText() + 3);
                    }
                } else {
                    TransferPanel.amount.setText(TransferPanel.amount.getText() + 3);
                }
            }
            if (e.getSource().equals(TransferPanel.b4)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        TransferPanel.amount.setText(TransferPanel.amount.getText() + 4);
                    }
                } else {
                    TransferPanel.amount.setText(TransferPanel.amount.getText() + 4);
                }
            }
            if (e.getSource().equals(TransferPanel.b5)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        TransferPanel.amount.setText(TransferPanel.amount.getText() + 5);
                    }
                } else {
                    TransferPanel.amount.setText(TransferPanel.amount.getText() + 5);
                }
            }
            if (e.getSource().equals(TransferPanel.b6)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        TransferPanel.amount.setText(TransferPanel.amount.getText() + 6);
                    }
                } else {
                    TransferPanel.amount.setText(TransferPanel.amount.getText() + 6);
                }
            }
            if (e.getSource().equals(TransferPanel.b7)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        TransferPanel.amount.setText(TransferPanel.amount.getText() + 7);
                    }
                } else {
                    TransferPanel.amount.setText(TransferPanel.amount.getText() + 7);
                }
            }
            if (e.getSource().equals(TransferPanel.b8)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        TransferPanel.amount.setText(TransferPanel.amount.getText() + 8);
                    }
                } else {
                    TransferPanel.amount.setText(TransferPanel.amount.getText() + 8);
                }
            }
            if (e.getSource().equals(TransferPanel.b9)) {
                if (y.length() > 2) {
                    if (!y.substring(x - 2, x - 1).equals(".")) {
                        TransferPanel.amount.setText(TransferPanel.amount.getText() + 9);
                    }
                } else {
                    TransferPanel.amount.setText(TransferPanel.amount.getText() + 9);
                }
            }
            if (e.getSource().equals(TransferPanel.bdecimal)) {
                if (!y.contains(".")) {
                    TransferPanel.amount.setText(TransferPanel.amount.getText() + ".");
                }
            }
            if (e.getSource().equals(TransferPanel.bx)) {
                if (y.length() > 0) {
                    try {
                        TransferPanel.amount.setText(TransferPanel.amount.getText(0, x));
                    } catch (BadLocationException ex) {
                        Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            if (e.getSource().equals(TransferPanel.transfer)) {
                if (y.length() > 0) {
                    if (TransferPanel.dropdown.getSelectedIndex() == 0) {
                        System.out.println("SAVINGS TO CHECKINGS");
                        if (John_Doe.TransferChecking(Double.parseDouble(y))) {
                            TransferPanel.error.setText("");
                            SummaryPanel(0);
                            BalancePanel(0);
                            addActivity("$" + y + " Transfered to Checking");
                        } else {
                            TransferPanel.error.setText("INSUFFICIENT FUNDS");
                        }

                    } else {
                        System.out.println("CHECKINGS");
                        if (John_Doe.TransferSaving(Double.parseDouble(y))) {
                            TransferPanel.error.setText("");
                            SummaryPanel(0);
                            BalancePanel(0);
                            addActivity("$" + y + " Transfered to Savings");
                        } else {
                            TransferPanel.error.setText("INSUFFICIENT FUNDS");
                        }
                    }
                    TransferPanel.amount.setText("");
                    System.out.println(John_Doe.getSaving());
                    System.out.println(John_Doe.getChecking());
                }
            }
        }

        public void addActivity(String activity) {
            int x = ActivityPanel.j.length;
            for (int i = 9; i > 0; i--) {
                if (!ActivityPanel.j[i - 1].getText().equals("")) {
                    ActivityPanel.j[i].setText(ActivityPanel.j[i - 1].getText());
                }
            }
            ActivityPanel.j[0].setText(activity);

        }
    }

    public void TransferPanel() {
        transferPanel = new TransferPanel();
        transferPanel.setBackground(Color.green);
        cards.add(transferPanel);
        TransferPanel.back.addActionListener(new BackAction());
        TransferPanel.b0.addActionListener(new TransferAction());
        TransferPanel.b1.addActionListener(new TransferAction());
        TransferPanel.b2.addActionListener(new TransferAction());
        TransferPanel.b3.addActionListener(new TransferAction());
        TransferPanel.b4.addActionListener(new TransferAction());
        TransferPanel.b5.addActionListener(new TransferAction());
        TransferPanel.b6.addActionListener(new TransferAction());
        TransferPanel.b7.addActionListener(new TransferAction());
        TransferPanel.b8.addActionListener(new TransferAction());
        TransferPanel.b9.addActionListener(new TransferAction());
        TransferPanel.bdecimal.addActionListener(new TransferAction());
        TransferPanel.bx.addActionListener(new TransferAction());
        TransferPanel.transfer.addActionListener(new TransferAction());
    }

    public void ChangePinPanel() {
        changePanel = new ChangePinPanel();
        changePanel.setBackground(Color.green);
        cards.add(changePanel);
        ChangePinPanel.back.addActionListener(new BackAction());
        ChangePinPanel.b0.addActionListener(new ChangePinAction());
        ChangePinPanel.b1.addActionListener(new ChangePinAction());
        ChangePinPanel.b2.addActionListener(new ChangePinAction());
        ChangePinPanel.b3.addActionListener(new ChangePinAction());
        ChangePinPanel.b4.addActionListener(new ChangePinAction());
        ChangePinPanel.b5.addActionListener(new ChangePinAction());
        ChangePinPanel.b6.addActionListener(new ChangePinAction());
        ChangePinPanel.b7.addActionListener(new ChangePinAction());
        ChangePinPanel.b8.addActionListener(new ChangePinAction());
        ChangePinPanel.b9.addActionListener(new ChangePinAction());
        ChangePinPanel.enter.addActionListener(new ChangePinAction());
        ChangePinPanel.bx.addActionListener(new ChangePinAction());
    }

    class ChangePinAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(ChangePinPanel.b0)) {
                if (x == 0 && PINCount < 4) {
                    ChangePinPanel.current_pin.setText(ChangePinPanel.current_pin.getText() + 0);
                    PINCount++;
                } else if (x == 1 && PINCount < 4) {
                    ChangePinPanel.new_pin.setText(ChangePinPanel.new_pin.getText() + 0);
                    PINCount++;
                } else if (x == 2 && PINCount < 4) {
                    ChangePinPanel.new_pin2.setText(ChangePinPanel.new_pin2.getText() + 0);
                    PINCount++;
                }
            }
            if (e.getSource().equals(ChangePinPanel.b1)) {
                if (x == 0 && PINCount < 4) {
                    ChangePinPanel.current_pin.setText(ChangePinPanel.current_pin.getText() + 1);
                    PINCount++;
                } else if (x == 1 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin.setText(ChangePinPanel.new_pin.getText() + 1);
                } else if (x == 2 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin2.setText(ChangePinPanel.new_pin2.getText() + 1);
                }
            }
            if (e.getSource().equals(ChangePinPanel.b2)) {
                if (x == 0 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.current_pin.setText(ChangePinPanel.current_pin.getText() + 2);
                } else if (x == 1 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin.setText(ChangePinPanel.new_pin.getText() + 2);
                } else if (x == 2 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin2.setText(ChangePinPanel.new_pin2.getText() + 2);
                }
            }
            if (e.getSource().equals(ChangePinPanel.b3)) {
                if (x == 0 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.current_pin.setText(ChangePinPanel.current_pin.getText() + 3);
                } else if (x == 1 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin.setText(ChangePinPanel.new_pin.getText() + 3);
                } else if (x == 2 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin2.setText(ChangePinPanel.new_pin2.getText() + 3);
                }
            }
            if (e.getSource().equals(ChangePinPanel.b4)) {
                if (x == 0 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.current_pin.setText(ChangePinPanel.current_pin.getText() + 4);
                } else if (x == 1 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin.setText(ChangePinPanel.new_pin.getText() + 4);
                } else if (x == 2 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin2.setText(ChangePinPanel.new_pin2.getText() + 4);
                }
            }
            if (e.getSource().equals(ChangePinPanel.b5)) {
                if (x == 0 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.current_pin.setText(ChangePinPanel.current_pin.getText() + 5);
                } else if (x == 1 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin.setText(ChangePinPanel.new_pin.getText() + 5);
                } else if (x == 2 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin2.setText(ChangePinPanel.new_pin2.getText() + 5);
                }
            }
            if (e.getSource().equals(ChangePinPanel.b6)) {
                if (x == 0 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.current_pin.setText(ChangePinPanel.current_pin.getText() + 6);
                } else if (x == 1 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin.setText(ChangePinPanel.new_pin.getText() + 6);
                } else if (x == 2 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin2.setText(ChangePinPanel.new_pin2.getText() + 6);
                }
            }
            if (e.getSource().equals(ChangePinPanel.b7)) {
                if (x == 0 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.current_pin.setText(ChangePinPanel.current_pin.getText() + 7);
                } else if (x == 1 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin.setText(ChangePinPanel.new_pin.getText() + 7);
                } else if (x == 2 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin2.setText(ChangePinPanel.new_pin2.getText() + 7);
                }
            }
            if (e.getSource().equals(ChangePinPanel.b8)) {
                if (x == 0 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.current_pin.setText(ChangePinPanel.current_pin.getText() + 8);
                } else if (x == 1 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin.setText(ChangePinPanel.new_pin.getText() + 8);
                } else if (x == 2 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin2.setText(ChangePinPanel.new_pin2.getText() + 8);
                }
            }
            if (e.getSource().equals(ChangePinPanel.b9)) {
                if (x == 0 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.current_pin.setText(ChangePinPanel.current_pin.getText() + 9);
                } else if (x == 1 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin.setText(ChangePinPanel.new_pin.getText() + 9);
                } else if (x == 2 && PINCount < 4) {
                    PINCount++;
                    ChangePinPanel.new_pin2.setText(ChangePinPanel.new_pin2.getText() + 9);
                }
            }
            if (e.getSource().equals(ChangePinPanel.bx)) {
                if (x == 0 && PINCount > 0) {
                    try {
                        PINCount--;
                        ChangePinPanel.current_pin.setText(ChangePinPanel.current_pin.getText(0, ChangePinPanel.current_pin.getText().length() - 1));
                    } catch (BadLocationException ex) {
                        Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (x == 1 && PINCount > 0) {
                    try {
                        PINCount--;
                        ChangePinPanel.new_pin.setText(ChangePinPanel.new_pin.getText(0, ChangePinPanel.new_pin.getText().length() - 1));
                    } catch (BadLocationException ex) {
                        Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (x == 2 && PINCount > 0) {
                    PINCount--;
                    try {
                        ChangePinPanel.new_pin2.setText(ChangePinPanel.new_pin2.getText(0, ChangePinPanel.new_pin2.getText().length() - 1));
                    } catch (BadLocationException ex) {
                        Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            if (e.getSource().equals(ChangePinPanel.enter)) {
                if (PINCount == 4 && x == 0) {
                    if (ChangePinPanel.current_pin.getText().equals(John_Doe.getPIN())) {
                        x++;
                        PINCount = 0;
                        ChangePinPanel.error.setText("CORRECT PIN");
                    } else {
                        ChangePinPanel.error.setText("INCORRECT PIN");
                        ChangePinPanel.current_pin.setText("");
                        PINCount = 0;
                    }
                } else if (PINCount == 4 && x == 1) {
                    x++;
                    PINCount = 0;
                } else if (PINCount == 4 && x == 2) {
                    if (ChangePinPanel.new_pin.getText().equals(ChangePinPanel.new_pin2.getText())) {
                        John_Doe.setPIN(ChangePinPanel.new_pin.getText());
                        ChangePinPanel.error.setText("PIN CHANGED");
                        x = 0;
                        PINCount = 0;
                        ChangePinPanel.current_pin.setText("");
                        ChangePinPanel.new_pin.setText("");
                        ChangePinPanel.new_pin2.setText("");
                    } else {
                        ChangePinPanel.error.setText("PINS DON'T MATCH");
                        ChangePinPanel.new_pin.setText("");
                        ChangePinPanel.new_pin2.setText("");
                        x--;
                        PINCount = 0;
                    }
                }
            }

        }

    }

}
