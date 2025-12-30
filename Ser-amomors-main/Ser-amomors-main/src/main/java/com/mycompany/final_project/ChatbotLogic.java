/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.final_project;

/**
 *
 * @author LENOVO-Pc
 */
import java.util.Random;

public class ChatbotLogic {
    private String userCategory = "";
    private String userBudget = "";
    private String userOccasion = "";

    public String getBotResponse(String input) {
        input = input.trim().toLowerCase();


        Random rand = new Random();

        String[] unknownReplies = {
            "Interesting! Para mas matulong kita, pwede mo pa bang i-clarify ang iyong question? Anong produkto o serbisyo ang hinahanap mo?",
            "Sorry, hindi ko maintindihan. Maaari mo bang sabihin nang specific ang iyong hinahanap?",
            "Pasensya ka na! Hindi ko maintindihan."
        };
        String reply = unknownReplies[rand.nextInt(unknownReplies.length)];

        // Question 1: Greeting
        if (input.contains("hi") || input.contains("hello") || input.contains("magandang araw") || 
            input.contains("kumusta")) {
            return "Kamusta! Masaya akong makita ka. Ano ang hinahanap mo sa aming tindahan?";
        }

        // Question 2: Product Categories
        if (input.contains("anong mga produkto") || input.contains("ano ang meron") || 
            input.contains("categories") || input.contains("uri") || input.contains("tinda")) {
            userCategory = "inquired";
            return "Mayroon kaming maraming kategorya: Damit, Sapatos, Accessories, Kagamitan sa Bahay, Kosmetika, at Elektroniks. Saan ka interesado?";
        }

        // Question 3: Clothing Department
        if (input.contains("damit") || input.contains("tela") || input.contains("shirt") || 
            input.contains("pants") || input.contains("short") || input.contains("brief") ||
            input.contains("panty") || input.contains("underwear") || input.contains("bra") ||
            input.contains("pantalon") || input.contains("sando")){
            userCategory = "clothing";
            return "Maganda! Sa aming Clothing Department, mayroon kaming casual wear, formal wear, at sports wear. Anong uri ng damit ang hinahanap mo?";
        }

        // Question 4: Budget Inquiry
        if (input.contains("presyo") || input.contains("magkano") || input.contains("budget") || 
            input.contains("mahal")) {
            return "Ano ang iyong budget range? Mayroon kaming affordable items mula ₱500 hanggang premium items na mahigit ₱5000.";
        }

        // Question 5: Budget Range - Affordable
        if (input.contains("500") || input.contains("mura") || input.contains("cheap") || 
            input.contains("affordable")) {
            userBudget = "affordable";
            return "Perpekto! Para sa iyong budget, recommend ko ang aming sale items at basics collection. Available pa ang 20% discount ngayong linggo!";
        }

        // Question 6: Budget Range - Premium
        if (input.contains("5000") || input.contains("premium") || input.contains("luxury")) {
            userBudget = "premium";
            return "Excellent choice! Mayroon kaming exclusive designer brands at high-quality items. Lahat ay guaranteed authentic at may warranty.";
        }

        // Question 7: Occasion-based Recommendation
        if (input.contains("okasyon") || input.contains("event")) {
            userOccasion = "special";
            return "Magandang tanong! Para sa anong okasyon ang iyong bilhin? Wedding, birthday party, graduation, o trabaho?";
        }

        // Question 8: Wedding Occasion
        if (input.contains("kasal") || input.contains("wedding")) {
            return "Para sa kasal, recommend ko ang aming formal wear section. May beautiful dresses, suits, at accessories na swak para sa iyong selebrasyon.";
        }

        // Question 9: Shoes Department
        if (input.contains("sapatos") || input.contains("shoes") || input.contains("tsinelas") || input.contains("slippers")) {
            userCategory = "shoes";
            return "Ayos! Sa Shoes Department, mayroon kaming casual sneakers, formal shoes, at comfortable sandals.";
        }

        // Question 10: Accessories
        if (input.contains("accessories") || input.contains("aksesoryo") || input.contains("bag") || 
            input.contains("alahas") || input.contains("watch") || input.contains("relo") || input.contains("kwintas") ||
            input.contains("hikaw") || input.contains("singsing") || input.contains("bracelet") || input.contains("shades") || input.contains("salamin")){
            return "Perfect! Mayroon kaming bags, belts, watches, jewelry, at marami pang ibang accessories. Gusto mo ba ng bag o jewelry?";
        }

        // Question 11: Home and Living
        if (input.contains("bahay") || input.contains("home") || input.contains("furniture") || 
            input.contains("kitchenware")) {
            userCategory = "home";
            return "Kami ay may complete selection ng furniture, bedding, kitchen items, at decorations.";
        }

        // Question 12: Electronics and Cosmetics
        if (input.contains("elektroniks") || input.contains("gadget") || input.contains("kosmetika") || 
            input.contains("makeup") || input.contains("cellphone") || input.contains("tablet") || input.contains("iphone")) {
            return "Ang Electronics section ay may latest gadgets at appliances. Ang Cosmetics section ay may international brands. Pumili kung anong section?";
        }

        // Question 13: Store Location and Hours
        if (input.contains("saan") || input.contains("location") || input.contains("oras") || 
            input.contains("ilan")) {
            return "Kami ay naka-locate sa San Pablo City, Laguna. Open kami mula 10AM - 9PM araw-araw.";
        }

        // Question 14: Payment Methods
        if (input.contains("bayad") || input.contains("payment") || input.contains("credit card") || 
            input.contains("cash") || input.contains("debit")) {
            return "Tumatanggap kami ng cash, credit card, debit card, at online payment methods. May installment option din para sa malalaking bill!";
        }

        // Question 15: Discounts and Promos
        if (input.contains("discount") || input.contains("sale") || input.contains("promo") || 
            input.contains("libre")) {
            return "Ngayong buwan, may 20-30% discount sa selected items. May loyalty card din kami na may exclusive benefits. Interested ka?";
        }

        // Question 16: Loyalty Program
        if (input.contains("loyalty") || input.contains("rewards") || input.contains("points") || 
            input.contains("member")) {
            return "Oo! Ang aming Members Club ay may points program. Bawat bili ay may corresponding points na pwedeng i-convert sa discounts. Mag-register ka na!";
        }

        // Question 17: Size and Fitting
        if (input.contains("size") || input.contains("laki") || input.contains("fit")) {
            return "Mayroon kaming professional staff na tutulong sa sizing at fitting. Available din ang alteration services para perfect ang fit ng iyong damit.";
        }

        // Question 18: Return and Exchange
        if (input.contains("return") || input.contains("exchange") || input.contains("warranty") || 
            input.contains("bumalik")) {
            return "30-day return policy kami with original receipt. Exchange ay available din ng libre. Lahat ng items may quality guarantee. Satisfied guaranteed!";
        }

        // Question 19: Recommendations
        if (input.contains("recommend") || input.contains("suggestion") || input.contains("advice") || 
            input.contains("tulong")) {
            if (!userCategory.isEmpty() && !userBudget.isEmpty()) {
                return "Based sa iyong preference, recommend ko ang aming " + userCategory + " collection sa " + userBudget + " range. Best sellers sila this season!";
            }
            return "Tell me more about what you need - category, budget, at occasion - para ma-give ko ang perfect recommendation para sa iyo!";
        }

        // Question 20: Thank You / Farewell
        if (input.contains("salamat") || input.contains("thank") || input.contains("bye") || 
            input.contains("goodbye") || input.contains("hanggang")) {
            return "Salamat sa iyong pagbisita! Bumalik ka ulit soon. Handa kaming maglingkod sa iyo. Have a great day!";
        }
        
        
        // Default Response
        return reply;
    }

    public void resetContext() {
        userCategory = "";
        userBudget = "";
        userOccasion = "";
    }
}
