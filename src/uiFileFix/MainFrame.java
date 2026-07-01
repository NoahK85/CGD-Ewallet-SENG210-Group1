package uiFileFix;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

		public MainFrame() {
			setTitle("E-Wallet App");
			setSize(500,400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			
			setLayout(new GridLayout(3,1,10,10));
			
			JButton savingBtn = new JButton("Saving Calculator");
			
			
			JButton currencyConversion = new JButton("Currency Convertor");
			
			savingBtn.addActionListener(e -> {
				new SavingCalcFrame();
			});
			
			currencyConversion.addActionListener(e -> {
				new CurrencyConversionFrame();
			});
			
			add(currencyConversion);
			add(savingBtn);
			setVisible(true);
		}
		public static void main(String[] args) {
			new MainFrame();
			
		}
}
