package alki4242.manager;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.FileReader;
import java.io.File;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class manager{
    JFrame pencere;
    Process yurut;
    public manager() {
        initalize();
    }
    public void initalize() {
        pencere = new JFrame();
        pencere.setResizable(false);
        File f = new File("./server.properties");
        Properties props = new Properties();
        if (f.exists()) {
            pencere.setSize(500, 500);
            pencere.setBounds(200, 200, 600, 700);
            pencere.setTitle("Sunucu Yonetim Paneli");
            JPanel ozpanel = new JPanel();
            ozpanel.setLayout(null);
            ozpanel.setBounds(10, 20, 1000, 700);
            pencere.add(ozpanel);
            JPanel panel = new JPanel();
            panel.setBorder((BorderFactory.createCompoundBorder(
                    BorderFactory.createTitledBorder("Ozellikler"),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5))));
            panel.setLayout(null);
            panel.setBounds(20, 50, 550, 250);
            ozpanel.add(panel);
            JPanel ayarlancak = new JPanel();
            JTabbedPane tp = new  JTabbedPane();
            tp.setBounds(1, 10, 580, 650);
            tp.add("Başlangıç", ozpanel);
            tp.add("Tercihler", ayarlancak);
            pencere.add(tp);
            try {
                FileReader reader = new FileReader(f);
                props.load(reader);
            } catch (Exception e) {

            }

            try {
                String str = "", str1 = "";
                FileReader fileread = new FileReader(f);
                BufferedReader bufferrd = new BufferedReader(fileread);
                str1 = bufferrd.readLine();
                while ((str = bufferrd.readLine()) != null) {
                    str1 = str1 + "\n" + str;
                }
            } catch (Exception ex) {

            }
            JLabel ip = new JLabel("IP ve Port");
            ip.setBounds(50, 30, 80, 20);
            panel.add(ip);
            JLabel ipandport = new JLabel();
            ipandport.setText("0.0.0.0");
            ipandport.setBounds(50, 50, 200, 20);
            pencere.setLayout(null);
            panel.add(ipandport);
            JTextArea port = new JTextArea();
            port.setBounds(90, 50, 50, 20);
            panel.add(port);
            port.setText(props.getProperty("server-port"));
            port.setBorder(BorderFactory.createLineBorder(Color.gray));
            JLabel sunucunamel = new JLabel("Sunucu adi:");
            sunucunamel.setBounds(50, 80, 80, 20);
            panel.add(sunucunamel);
            JTextArea sunucunamet = new JTextArea();
            sunucunamet.setBounds(120, 80, 100, 20);
            sunucunamet.setBorder(BorderFactory.createLineBorder(Color.gray));
            panel.add(sunucunamet);
            sunucunamet.setText(props.getProperty("server-name"));
            JLabel aciklamal = new JLabel("MOTD:");
            aciklamal.setBounds(50, 100, 50, 20);
            panel.add(aciklamal);
            JTextArea aciklamat = new JTextArea();
            aciklamat.setBounds(100, 100, 400, 20);
            panel.add(aciklamat);
            aciklamat.setBorder(BorderFactory.createLineBorder(Color.gray));
            aciklamat.setText(props.getProperty("motd"));
            JLabel maxoyuncul = new JLabel("Max Oyuncu:");
            maxoyuncul.setBounds(50, 130, 80, 20);
            panel.add(maxoyuncul);
            JTextArea maxoyuncut = new JTextArea();
            maxoyuncut.setBounds(130, 130, 50, 20);
            panel.add(maxoyuncut);
            maxoyuncut.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            maxoyuncut.setText(props.getProperty("max-players"));
            JLabel onlinemodel = new JLabel("Online-Mode:");
            onlinemodel.setBounds(50, 151, 80, 20);
            panel.add(onlinemodel);
            JTextArea onlinemodet = new JTextArea();
            onlinemodet.setBounds(130, 151, 50, 20);
            onlinemodet.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            panel.add(onlinemodet);
            onlinemodet.setText(props.getProperty("online-mode"));
            JLabel netherl = new JLabel("Nether acik:");
            netherl.setBounds(50, 172, 80, 20);
            panel.add(netherl);
            JTextArea nethert = new JTextArea();
            nethert.setBounds(130, 172, 50, 20);
            panel.add(nethert);
            nethert.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            nethert.setText(props.getProperty("allow-nether"));
            JLabel pvpl = new JLabel("      PVP:");
            pvpl.setBounds(50, 193, 80, 20);
            panel.add(pvpl);
            JTextArea pvpt = new JTextArea();
            pvpt.setBounds(130, 193, 50, 20);
            panel.add(pvpt);
            pvpt.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            pvpt.setText(props.getProperty("pvp"));
            JLabel debugl = new JLabel("     Debug:");
            debugl.setBounds(50, 214, 80, 20);
            panel.add(debugl);
            JTextArea debugt = new JTextArea();
            debugt.setBounds(130, 214, 50, 20);
            panel.add(debugt);
            debugt.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            debugt.setText(props.getProperty("debug"));
            //
            JLabel hardcorel = new JLabel("Hardcore:");
            hardcorel.setBounds(200, 130, 80, 20);
            panel.add(hardcorel);
            JTextArea hardcoret = new JTextArea();
            hardcoret.setBounds(280, 130, 50, 20);
            panel.add(hardcoret);
            hardcoret.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            hardcoret.setText(props.getProperty("hardcore"));
            JLabel zorlukl = new JLabel("Zorluk:");
            zorlukl.setBounds(200, 151, 80, 20);
            panel.add(zorlukl);
            JTextArea zorlukt = new JTextArea();
            zorlukt.setBounds(280, 151, 50, 20);
            panel.add(zorlukt);
            zorlukt.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            zorlukt.setText(props.getProperty("difficulty"));
            JLabel whl = new JLabel("Whitelist:");
            whl.setBounds(200, 172, 80, 20);
            panel.add(whl);
            JTextArea wht = new JTextArea();
            wht.setBounds(280, 172, 50, 20);
            panel.add(wht);
            wht.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            wht.setText(props.getProperty("white-list"));
            JLabel npcdogmal = new JLabel("NPC Dogmasi:");
            npcdogmal.setBounds(200, 193, 80, 20);
            panel.add(npcdogmal);
            JTextArea npcdogmat = new JTextArea();
            npcdogmat.setBounds(280, 193, 50, 20);
            panel.add(npcdogmat);
            npcdogmat.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            npcdogmat.setText(props.getProperty("spawn-npcs"));
            JLabel hayvandogmal = new JLabel("Hayvan Dogmasi:");
            hayvandogmal.setBounds(200, 214, 80, 20);
            panel.add(hayvandogmal);
            JTextArea hayvandogmat = new JTextArea();
            hayvandogmat.setBounds(280, 214, 50, 20);
            panel.add(hayvandogmat);
            hayvandogmat.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            hayvandogmat.setText(props.getProperty("spawn-animals"));
            JLabel oyunmodul = new JLabel("Oyun Modu:");
            oyunmodul.setBounds(340, 130, 80, 20);
            panel.add(oyunmodul);
            JTextArea oyunmodut = new JTextArea();
            oyunmodut.setBounds(420, 130, 80, 20);
            panel.add(oyunmodut);
            oyunmodut.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            oyunmodut.setText(props.getProperty("gamemode"));
            JLabel wiewl = new JLabel("View-Distance:");
            wiewl.setBounds(340, 151, 100, 20);
            panel.add(wiewl);
            JTextArea wiewt = new JTextArea();
            wiewt.setBounds(450, 151, 50, 20);
            panel.add(wiewt);
            wiewt.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            wiewt.setText(props.getProperty("view-distance"));
            JLabel allowflyl = new JLabel("Ucmak acik:");
            allowflyl.setBounds(340, 171, 80, 20);
            panel.add(allowflyl);
            JTextArea allowflyt = new JTextArea();
            allowflyt.setBounds(450, 171, 50, 20);
            panel.add(allowflyt);
            allowflyt.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            allowflyt.setText(props.getProperty("allow-flight"));
            JLabel spwanmosterl = new JLabel("Mob Dogmasi:");
            spwanmosterl.setBounds(340, 191, 80, 20);
            panel.add(spwanmosterl);
            JTextArea spwanmostert = new JTextArea();
            spwanmostert.setBounds(450, 191, 50, 20);
            panel.add(spwanmostert);
            spwanmostert.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            spwanmostert.setText(props.getProperty("spawn-monsters"));
            JLabel komutblokl = new JLabel("Komut Bloklari:");
            komutblokl.setBounds(340, 211, 100, 20);
            panel.add(komutblokl);
            JTextArea komutblokt = new JTextArea();
            komutblokt.setBounds(450, 211, 50, 20);
            panel.add(komutblokt);
            komutblokt.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            komutblokt.setText(props.getProperty("enable-command-block"));
            
            JLabel arguemntbilgi = new JLabel("JVM Baslangic argumentleri");
            arguemntbilgi.setBounds(50, 320, 200, 40);
            ozpanel.add(arguemntbilgi);
            JTextArea argument = new JTextArea();
            argument.setBounds(50, 350, 400, 200);
            argument.setLineWrap(true);
            argument.setBorder(BorderFactory.createLineBorder(Color.gray));
            String str = "", str1 = "";
            try {
                File bat = new File("./start.bat");
                FileReader fileread = new FileReader(bat);
                BufferedReader bufferrd = new BufferedReader(fileread);
                str1 = bufferrd.readLine();
                while ((str = bufferrd.readLine()) != null) {
                    str1 = str1 + "\n" + str;
                }
            } catch (Exception ex) {

            }
            argument.setText(str1);
            ozpanel.add(argument);
            JButton start = new JButton("Baslat");
            start.setBounds(50, 560, 80, 40);
            ozpanel.add(start);
            File bat = new File("./start.bat");
            String[] command = { "cmd.exe", "/C", "Start", bat.getAbsolutePath() };
            ProcessBuilder pb = new ProcessBuilder(command);
            
            start.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (bat.exists()) {
                        try {
                            
                            yurut = pb.start();
                            
                            JOptionPane.showMessageDialog(pencere,
                                    "Baslatildi Konsolu kontrol ediniz!");
                            
                        } catch (Exception aww) {
                            JOptionPane.showMessageDialog(pencere,
                                    aww);
                        }
                    } else {

                        JOptionPane.showMessageDialog(pencere,
                                "Luütfen JVM argümentlerini calistirmadan once kaydediniz!");
                    }

                }
            });
            JButton restart = new JButton("Y.Baslat");
            restart.setBounds(140, 560, 80, 40);
            // pencere.add(restart);
            restart.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	try {
                	Runtime.getRuntime().exec("taskkill /IM cmd.exe"); 
                	yurut = pb.start();
                	
                	} catch (Exception off) {}
                    JOptionPane.showMessageDialog(pencere,
                            "Yeniden Başlatıldı Konsolu kontrol ediniz!");
                }
            });
           
            ozpanel.add(restart);
            JButton reload = new JButton("Yenile");
            reload.setBounds(140, 610, 80, 40);
            // pencere.add(reload);
            reload.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	
                    JOptionPane.showMessageDialog(pencere,
                            "Yenileniyor Konsolu kontrol ediniz!");
                    pb.command("cmd.exe", "/C", "stop");
                    
                }
            });
         
            JButton stop = new JButton("Durdur");
            stop.setBounds(230, 560, 80, 40);
            // pencere.add(stop);
            stop.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {                   	
                    	Runtime.getRuntime().exec("taskkill /IM cmd.exe");	
                    	
                    } catch (Exception abe) {
                    	JOptionPane.showMessageDialog(pencere,abe);
                    }
                    JOptionPane.showMessageDialog(pencere,
                            "Durduruluyor Konsolu kontrol ediniz!");
                }
            });
            ozpanel.add(stop);
            JButton skript = new JButton("Skript Yaz");
            skript.setBounds(490, 500, 100, 40);
            ozpanel.add(skript);
            skript.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { 
                	JFrame skriptp = new JFrame();
                	skriptp.setTitle("Skript");
                	skriptp.setBounds(100, 100, 400, 400);
                	skriptp.setVisible(true);
                	JTextArea jta = new JTextArea();	
                	skriptp.add(jta, BorderLayout.CENTER);
                	JMenuBar jmb = new JMenuBar();
                	skriptp.setJMenuBar(jmb);
                	JMenu kayıt = new JMenu("Dosya");
                	jmb.add(kayıt);
                	JMenuItem jmı = new JMenuItem("Kaydet");
                	kayıt.add(jmı);
                	jmı.addActionListener(new ActionListener() {
                		public void actionPerformed(ActionEvent e) {
                			File sk = new File("plugins/Skript/script/New.sk");
                			try {
                				FileWriter sz = new FileWriter(sk,false);
                				BufferedWriter sb = new BufferedWriter(sz);
                				sb.write(jta.toString());
                				sb.close();
                				JOptionPane.showMessageDialog(skript, "Skript Kayıt edildi!");
                			} catch (Exception absda) {
                				JOptionPane.showMessageDialog(skript,absda);
                			}
                		}
                	});
                }});
            JButton kaydet = new JButton("Kaydet");
            kaydet.setBounds(490, 580, 80, 40);
            ozpanel.add(kaydet);
            kaydet.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    File bat = new File("./start.bat");
                    props.setProperty("server-port", port.getText());
                    props.setProperty("motd", aciklamat.getText());
                    props.setProperty("max-players", maxoyuncut.getText());
                    props.setProperty("allow-nether", nethert.getText());
                    props.setProperty("pvp", pvpt.getText());
                    props.setProperty("debug", debugt.getText());
                    props.setProperty("hardcore", hardcoret.getText());
                    props.setProperty("difficulty", zorlukt.getText());
                    props.setProperty("white-list", wht.getText());
                    props.setProperty("spawn-npcs", npcdogmat.getText());
                    props.setProperty("spawn-animals", hayvandogmat.getText());
                    props.setProperty("gamemode", oyunmodut.getText());
                    props.setProperty("view-distance", wiewt.getText());
                    props.setProperty("allow-flight", allowflyt.getText());
                    props.setProperty("spawn-monsters", spwanmostert.getText());
                    props.setProperty("enable-command-block", komutblokt.getText());
                    try {
                        FileWriter filewriter = new FileWriter(bat, false);
                        BufferedWriter bufferwr = new BufferedWriter(filewriter);
                        bufferwr.write(argument.getText());
                        bufferwr.flush();
                        bufferwr.close();
                    } catch (Exception i) {

                    }

                    try {
                        props.store(new FileOutputStream("./server.properties"), null);
                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(pencere,
                                "Hata:" + a);
                    }

                    JOptionPane.showMessageDialog(pencere,
                            "Tum değişiklikler kaydedildi!");
                }
            });
        } else {
            JOptionPane.showMessageDialog(pencere,
                    "server.properties dosyası bulunamadı. \n Programın çalısması"
                            + " için lütfen server.properties dosyasını oluşturtunuz");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        manager pencerem = new manager();
        pencerem.pencere.setVisible(true);
    }

}