package com.sklsongkiat.scraping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App {
	
	static int count_sum1 = 0;
	static int count_new1 = 0;
	static int count_sum2 = 0;
	static int count_new2 = 0;
	
    public static void main( String[] args ) throws Exception{
        try {
        	Document doc = Jsoup.connect("https://ddc.moph.go.th/viralpneumonia/").get();
        	System.out.printf("Title: %s\n", doc.title());
        	
        	Elements covid19Thai = doc.getElementsByClass("bgsmall");
        	
        	for(Element covid19Th : covid19Thai) {
        		
        		// title
        		String covid19ThTitle = covid19Th.getElementsByClass("modal-title").text();
        		String covid19ThDateTime = covid19Th.getElementsByClass("popup_hh").text();
        		
                System.out.println("\t" + covid19ThTitle);
                System.out.println("\t" + covid19ThDateTime);
                System.out.println("\n");
                
                String covid19ThPatiantHeader = covid19Th.getElementsByClass("popup_head").text();
                String[] split_header = covid19ThPatiantHeader.split(" ");
                
                for(String split_headered : split_header) {
                	
                	if(split_headered.equals("ผู้ป่วยยืนยัน")) {
                		System.out.println("\t" + split_headered + "(คน)");

                        String covid19ThPatiantSubHead = covid19Th.getElementsByClass("popup_subhead").text();
                        String[] split_subheader = covid19ThPatiantSubHead.split(" ");
                        
                        for(String split_subheaded : split_subheader) {
                        	
                        	String covid19ThPatiantNum = covid19Th.getElementsByClass("popup_num").text();
                            String[] split_NumPatiant = covid19ThPatiantNum.split(" ");
                            
                        	for(int i=0;i<split_NumPatiant.length;i++) {
                        		
                        		if(split_subheaded.equals("สะสม") && count_sum1 == 0) {
                            		System.out.println("\t" + split_subheaded + " = " + split_NumPatiant[0] + ", ");
                            		count_sum1++;
                                    break;
                            	}else if(split_subheaded.equals("รายใหม่") && count_new1 == 0) {
                            		System.out.println("\t" + split_subheaded + " = " + split_NumPatiant[1] + ", ");
                            		count_new1++;
                                    break;
                            	}else if(split_subheaded.equals("รุนแรง")) {
                            		System.out.println("\t" + split_subheaded + " = " + split_NumPatiant[2] + ", ");
                                    break;
                            	}else if(split_subheaded.equals("เสียชีวิต")) {
                            		System.out.println("\t" + split_subheaded + " = " + split_NumPatiant[3] + ", ");
                                    break;
                            	}else if(split_subheaded.equals("กลับบ้านแล้ว")) {
                            		System.out.println("\t" + split_subheaded + " = " + split_NumPatiant[4] + ", ");
                                    break;
                            	}
                            }
                        }
                        System.out.print("\n\n");
                	}
                	
                	if(split_headered.equals("ผู้ป่วยเข้าเกณฑ์ห์เฝ้าระวัง")) {
                		System.out.println("\t" + split_headered + "(คน)");

                        String covid19ThPatiantSubHead = covid19Th.getElementsByClass("popup_subhead").text();
                        String[] split_subheader = covid19ThPatiantSubHead.split(" ");
                        
                        for(String split_subheaded : split_subheader) {
                        	
                        	String covid19ThPatiantNum = covid19Th.getElementsByClass("popup_num").text();
                            String[] split_NumPatiant = covid19ThPatiantNum.split(" ");
                            
                        	for(int i=0;i<split_NumPatiant.length;i++) {
                        	
                        		if(split_subheaded.equals("สะสม") && count_sum2 == 0) {
                            		System.out.println("\t" + split_subheaded + " = " + split_NumPatiant[5] + ", ");
                            		count_sum2++;
                                    break;
                            	}else if(split_subheaded.equals("รายใหม่") && count_new2 == 0) {
                            		System.out.println("\t" + split_subheaded + " = " + split_NumPatiant[6] + ", ");
                            		count_new2++;
                                    break;
                            	}
                            }
                        }
                        System.out.print("\n\n");
                	}
                	
                	if(split_headered.equals("รักษาพยาบาลคน")) {
                		System.out.println("\t" + split_headered + "(คน)");

                        String covid19ThPatiantSubHead = covid19Th.getElementsByClass("popup_subhead").text();
                        String[] split_subheader = covid19ThPatiantSubHead.split(" ");
                        
                        for(String split_subheaded : split_subheader) {
                        	
                        	String covid19ThPatiantNum = covid19Th.getElementsByClass("popup_num").text();
                            String[] split_NumPatiant = covid19ThPatiantNum.split(" ");
                            
                        	for(int i=0;i<split_NumPatiant.length;i++) {
                        		if(split_subheaded.equals("อยู่")) {
                            		System.out.println("\t" + split_subheaded + " รพ. = " + split_NumPatiant[7] + ", ");
                                    break;
                            	}else if(split_subheaded.equals("กลับบ้าน")) {
                            		System.out.println("\t" + split_subheaded + " = " + split_NumPatiant[8] + ", ");
                                    break;
                            	}else if(split_subheaded.equals("สังเกตอาการ")) {
                            		System.out.println("\t" + split_subheaded + " = " + split_NumPatiant[9] + ", ");
                                    break;
                            	}
                            }
                        }
                        System.out.print("\n\n");
                	}
                }
        	}
        	
        }catch (IOException e) {
        	e.printStackTrace();
        }
        
        MySqlAccess dao = new MySqlAccess();
        dao.readDataBase();
    }
}
