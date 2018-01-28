package niklas.app.allergydictionary;

import java.util.Locale;

/**
 * Created by nwuensche on 28.01.18.
 */

public class DataStorage {
    
    public static String[] AllergeneNutzer;
    public static String[] LänderNutzer;
    public static String WeiterButtonText;
    public static String BeendenBText;
    public static int ForeignCountryID;
    public static boolean[] isMarked;


    public static String[] AllergeneDeutschland = { "Haselnuss", "Walnuss", "Erdnuss", "Paranuss", "Cashewnuss", "Macadamia", "Mandel", "Pistazie", "Gluten","Krebstiere","Ei","Fisch","Soja","Milchprodukte", "Schalenfrüchte","Sellerie","Senf","Sesam","Schwefel","Lupinen","Weichtiere"};
    public static String[] AllergeneEngland = {"hazelnut", "walnut", "peanut", "Brazil nut", "cashew", "macadamia", "almond", "pistachio", "gluten", "crustacean", "egg", "fish", "soy","Dairy","Nuts","Celery","Mustard","Sesame","Sulfur","Lupine","Mollusc"};
    public static String[] AllergeneFrankreich = {"Noisette", "noix", "arachides", "noix du Brésil", "noix de cajou", "macadamia", "amande", "pistache", "sans gluten", "crustacés", "oeuf", "poisson", "soja","les produits laitiers","Noix","Céleri","Moutarde" ,"sésame","soufre","lupin","mollusque"};
    public static String[] AllergeneSpanien = {"avellana", "nueces", "maní", "nuez de Brasil", "cajú", "macadamia", "almendra", "pistachos", "gluten", "crustáceos", "huevo", "pescado", "soja","Productos lácteos","Nueces","Apio","Mostaza","Sésamo","Azufre","Chocho","Moluscos"};
    public static String[] AllergenePortugal = {"avelã", "noz", "amendoim", "castanha do Brasil", "caju", "macadâmia", "amendoeiras", "pistachio", "glúten", "crustáceo", "ovo", "pescar", "soy","Produtos lácteos","Castanhas","Aipo","Mostarda","Gergelim","Enxofre","Tremoço","Molusco"};
    public static String[] AllergeneItalien = {"nocciola", "noce", "peanut", "noci del Brasile", "cashew", "macadamia", "a mandorla", "pistacchio", "glutine", "crostaceo", "uovo", "pesce", "soy","Latte","Noci","Sedano","Senape","Sesamo","Di zolfo","Lupin","Mollusco"};
    public static String[] AllergeneDänemark = {"hasselnød", "valnød", "peanut", "Brazil nut", "cashew", "macadamia", "mandel", "pistacie", "gluten", "krebsdyr", "æg", "fisk", "soja","Mejeri","Nuts","Selleri","Sennep","Sesam","Svovl","Lupin","Bløddyr"};
    public static String[] AllergeneSchweden = {"hasselnöt", "valnöt", "jordnöt", "Brasilien nöt", "cashew", "makadamianötter", "almond", "pistage", "gluten", "kräftdjur", "ägget", "fisk", "soja","Mejeri","Nötter","Selleri","Senap","Sesam","Svavel","Lupin","Blötdjur"};
    public static String[] AllergeneNorwegen = {"Hasselnøtter", "valnøtt", "peanut", "Brazil nut", "cashew", "macadamia", "mandel", "pistasj", "gluten", "krepsdyr", "egg", "fisk", "soya","Meieri","Nøtter","Selleri","Sennep","Sesam","Svovel","Lupin","Bløtdyr"};
    public static String[] AllergeneFinnland = {"hasselpähkinä", "saksanpähkinä", "maapähkinä", "Brazil nut", "cashew", "macadamia", "manteli", "pistaasi", "gluteeniton", "äyriäinen", "muna", "fish", "soy","Meijeri","Pähkinät","Selleri","Sinappia","Seesami","Rikki","Lupiini","Nilviäinen"};
    public static String[] AllergeneNiederlande = {"hazelnoot", "walnoot", "peanut", "Brazil nut", "cashew", "macadamia", "almond", "pistache", "gluten", "schaaldieren", "ei", "fish", "soy","Zuivel","Nuts","Selderij","Mustard","Sesame","Zwavel","Lupine","Mollusc"};
    public static String[] AllergeneTürkei = {"fındık", "ceviz", "fıstık", "Brezilya fıstığı", "kaju", "macadamia", "badem", "fıstık", "gluten", "kabuklu", "yumurta", "balık", "soy","Süt","Fındık","Kereviz","Hardal","Susam","Kükürt","Kurt","Yumuşakça"};
    public static String[] AllergeneKroatien = {"lješnjak", "oraha", "kikiriki", "Brazil orah", "kasu", "australski", "badem", "pistacija", "glutena", "rak", "Jaje", "riba", "od soje","Mliječni","Matice","Celer","Senf","Sezam","Sumpor","Lupina","Mekušaca"};
    public static String[] AllergeneGriechenland = {
            "φουντούκι", "καρύδι", "φυστίκι", "καρύδι Βραζιλίας", "κάσιους", "macadamia", "αμύγδαλο", "φιστίκι", "χωρίς γλουτένη", "καρκινοειδών", "αυγό", "ψάρι", "σόγια "," γαλακτοκομικά "," καρύδια "," σέλινο "," μουστάρδα "," σουσάμι "," θείο "," λούπινα "," μαλάκιο "};
    public static String[] AllergeneUngarn = {"mogyoró", "dió", "földimogyoró", "brazil dió", "kesudió", "macadamia", "mandula", "pisztácia", "glutén", "rákok", "tojás", "hal", "szója","Tejtermékek","Dió ","Zeller","Mustár","Szezám","Kén","Csillagfürt","Puhatestű "};
    public static String[] AllergeneRussland = {
            "фундук", "грецкий орех", "арахисовое", "Бразильский орех", "кешью", "макадамии", "Миндаль", "фисташки", "клейковины", "рачок", "яйцо", "рыба", "соевый "," молочные продукты "," гайки "," сельдерей "," горчица "," кунжутное "," сера "," люпина "," моллюск "};
    public static String[] AllergeneTschechien = {"lískový ořech", "vlašský ořech", "arašíd", "Brazil ořech", "kešu", "macadamia", "mandle", "pistácie", "lepek", "korýš", "vejce", "ryba", "soy"," mléčné výrobky"," ořechy", "celer","hořčice","sezam","síra","vlčí bob","měkkýši"};
    public static String[] AllergeneSlowakei = {"lieskový orech", "vlašský orech", "arašidy", "Brazil orech", "kešu", "macadamia", "mandle", "pistácie", "lepok", "kôrovec", "vajcia", "ryba", "soy","Mliečne výrobky","Orechy","Zeler","Horčica","Sezam","Síra","Vlčí ","Mäkkýše"};
    public static String[] AllergeneSlowenien = {"lešnik", "oreh", "arašide", "Brazilija oreh", "indijski", "makadamija", "mandelj", "pistacija", "gluten", "raki", "jajce", "ribe", "soja","Mlečni","Orehi","Zelena","Gorčica","Sezamovo"," žvepla","Volčji bob","Mehkužcev"};
    public static String[] AllergenePolen = {
            "orzech laskowy", "orzech włoski", "orzeszki ziemne", "orzech Brazil", "nerkowca", "macadamia", "migdał", "pistacjowy", "gluten", "skorupiak", "jajko", "ryba", "sojowego","Mleczarnia","Orzechy","Seler","Musztarda","Sezam","Siarka","Wilczy","Mięczaków"};
    public static String[] AllergeneBulgarien = {"лешник", "орех", "фъстъчен", "Бразилия гайка", "кашу", "макадамия", "бадем", "шам-фъстък", "без глутен", "ракообразно", "яйце", "риба", "соев "," млечни продукти "," ядки "," целина "," горчица "," сусам "," серен "," вълчи "," мекотели "};
    public static String[] AllergeneArabien = {"بندق", "خشب الجوز", "الفول السوداني", "البرازيل الجوز", "الكاجو", "المكاديميا", "اللوز", "الفستق", "الغلوتين", "القشريات", "البيضة", "الأسماك", "الصويا "," منتجات الألبان "," المكسرات "," الكرفس "," الخردل "," السمسم "," الكبريت "," الترمس "," الرخويات "};
    public static String[] AllergeneChina = {"榛子","核桃","花生","巴西果","腰果","夏威夷","杏仁","开心果","面筋","甲壳","蛋","鱼","酱油","乳制品","坚果","芹菜","榨菜","芝麻","硫磺","鲁冰花","软体动物"};
    public static String[] AllergeneJapan = {"ヘーゼルナッツ","ウォールナット","ピーナッツ","ブラジルナッツ","カシュー","マカダミア","アーモンド","ピスタチオ","グルテン","甲殻類","たまご","魚","大豆","乳製品","ナッツ","セロリ","マスタード","ゴマ","硫黄","ルピナス","軟体動物"};

    public static String[] LänderDeutschland = { "Deutschland","England","Frankreich","Spanien","Portugal", "Italien","Dänemark","Schweden", "Norwegen", "Finnland", "Niederlande","Türkei", "Kroatien","Griechenland","Ungarn", "Russland", "Tschechien", "Slowakei", "Slowenien", "Polen",  "Bulgarien","Arabien", "China", "Japan"};
    public static String[] LänderEngland ={"Germany", "England", "France", "Spain", "Portugal", "Italy", "Denmark", "Sweden", "Norway", "Finland", "Netherlands", "Turkey", "Croatia","Greece","Hungary","Russia","Czech Republic","Slovakia","Slovenia","Poland","Bulgaria","Arabia","China","Japan"};
    public static String[] LänderFrankreich ={"Allemagne", "l'Angleterre", "France", "Espagne", "Portugal", "Italie", "le Danemark", "La Suède", "la Norvège", "la Finlande", "Pays-Bas", "la Turquie", "Croatie","Grèce","Hongrie","Russie","République tchèque","Slovaquie","Slovénie","La Pologne","La Bulgarie","Arabia","Chine","Japon"};
    public static String[] LänderSpanien ={
            "Alemania", "Inglaterra", "Francia", "España", "Portugal", "Italia", "Dinamarca", "Suecia", "Noruega", "Finlandia", "Países Bajos", "Turquía", "Croacia","Grecia","Hungría","Rusia","República Checa","Eslovaquia","Eslovenia","Polonia","Bulgaria","Arabia","China","Japón"};
    public static String[] LänderPortugal ={"Alemanha", "Inglaterra", "França", "Spain", "Portugal", "Itália", "Dinamarca", "Suécia", "Noruega", "Finlândia", "Países Baixos", "turquia", "Croatia","Grécia","Hungria","Rússia","República Checa","Eslováquia","Slovenia","Polónia","Bulgária","Arábia","China","Japão"};
    public static String[] LänderItalien ={"Germania", "England", "Francia", "Spain", "Portugal", "Italia", "la Danimarca", "Svezia", "Norvegia", "Finlandia", "Paesi Bassi", "Turchia", "Croazia","Grecia","L'Ungheria","Russia","Repubblica Ceca","Slovacchia","Slovenia","La Polonia","Bulgaria","Arabia","Cina","Japan"};
    public static String[] LänderDänemark ={"Tyskland", "England", "France", "Spanien", "Portugal", "Italien", "Danmark", "Sverige", "Norge", "Finland", "Holland", "Tyrkiet", "Kroatien","Grækenland","Ungarn","Rusland","Tjekkiet","Slovakiet","Slovenien","Polen","Bulgarien","Arabia","China","Japan"};
    public static String[] LänderSchweden ={
            "Tyskland", "England", "Frankrike", "Spanien", "Portugal", "Italien", "Danmark", "Sverige", "Norge", "Finland", "Nederländerna", "Turkiet", "Kroatien","Grekland","Ungern","Ryssland","Tjeckien","Slovakien","Slovenien","Polen","Bulgarien","Arabien","Kina","Japan"};
    public static String[] LänderNorwegen ={
            "Germany", "England", "Frankrike", "Spain", "Portugal", "Italia", "Danmark", "Sverige", "Norge", "Finland", "Nederland", "Turkey", "Kroatia","Hellas","Ungarn","Russland","Tsjekkia","Slovakia","Slovenia","Polen","Bulgaria","Arabia","China","Japan"};
    public static String[] LänderFinnland ={"Saksa", "England", "France", "Espanja", "Portugali", "Italia", "Denmark", "Ruotsi", "Norja", "Suomi", "Alankomaat", "Turkki", "Croatia","Kreikka","Unkari","Venäjä ","Tšekki","Slovakia","Slovenia","Puola","Bulgaria","Arabian","Kiina","Japan"};
    public static String[] LänderNiederlande ={
            "Duitsland", "Engeland", "Frankrijk", "Spanje", "Portugal", "Italië", "Denemarken", "Zweden", "Noorwegen", "Finland", "Nederland", "Turkije", "Kroatië ","Griekenland","Hongarije","Rusland","Tsjechië ","Slowakije","Slovenië ","Polen","Bulgarije","Arabia","China","Japan"};
    public static String[] LänderTürkei ={"Almanya", "İngiltere", "Fransa", "Spain", "Portekiz", "İtalya", "Danimarka", "İsveç", "Norveç", "Finlandiya", "Hollanda", "Türkiye", "Hırvatistan","Yunanistan","Macaristan","Rusya"," Çek Cumhuriyeti","Slovakya","Slovenya","Polonya","Bulgaristan","Arabistan"," Çin","Japonya"};
    public static String[] LänderKroatien ={"Njemačka", "Engleska", "Francuska", "Španjolska", "Portugal", "Italija", "Danska", "Švedska", "Norveška", "Finska", "Nizozemska", "Turska", "Hrvatska","Grčka","Mađarska","Rusija"," Češka Republika","Slovačka","Slovenija","Poljska","Bugarska","Arabije","Kina","Japan"};
    public static String[] LänderGriechenland ={"Γερμανία", "Αγγλία", "Γαλλία", "Ισπανία", "Πορτογαλία", "Ιταλία", "Δανία", "Σουηδία", "Νορβηγία", "Φινλανδία", "Κάτω", "Τουρκία", "Κροατία "," Η Ελλάδα "," Ουγγαρία "," Ρωσία "," Τσεχική Δημοκρατία "," Σλοβακία "," Σλοβενία "," Πολωνία "," Βουλγαρία "," Αραβία "," η Κίνα "," Ιαπωνία "};
    public static String[] LänderUngarn ={
            "Németország", "England", "Franciaország", "Spanyolország", "Portugália", "Olaszország", "Dánia", "Svédország", "Norvégia", "Finnország", "Hollandia", "Törökország", "Horvátország","Görögország","Magyarország","Oroszország","Csehország","Szlovákia","Szlovénia","Kengyelország","Bulgária","Arábia","Kína","Japán"};
    public static String[] LänderRussland ={"Германия", "Англия", "Франция", "Испания", "Португалия", "Италия", "Дания", "Швеция", "Норвегия", "Финляндия", "Нидерланды", "Турция", "Хорватия "," Греция "," Венгрия "," Россия "," Чехия "," Словакия "," Словения "," Польша "," Болгария "," Аравия "," Китай "," Япония "};
    public static String[] LänderTschechien = {"Německo", "Anglie", "Francie", "Španělsko", "Portugalsko", "Itálie", "Dánsko", "Švédsko", "Norsko", "Finsko", "Nizozemsko", "Turecko", "Chorvatsko", "Řecko","Maďarsko","Rusko","česká republika","Slovensko","Slovinsko","Polsko","Bulharsko","Arábie","Čína","Japan"};
    public static String[] LänderSlowakei ={"Nemecko", "Anglicko", "Francúzsko", "Španielsko", "Portugalsko", "Taliansko", "Dánsko", "Švédsko", "Nórsko", "Fínsko", "Holandsko", "Turecko", "Chorvátsko","Grécko","Maďarsko","Rusko"," Česká republika","Slovensko","Slovinsko","Poľsko","Bulharsko","Arábia"," Čína","Japan"};
    public static String[] LänderSlowenien ={"Nemčija", "England", "Francija", "Španija", "Portugalska", "Italija", "Danska", "Švedska", "Norveška", "Finska", "Nizozemska", "Turčija", "Hrvaška","Grčija","Madžarska","Rusija"," Češka","Slovaška","Slovenija","Poljska","Bolgarija","Arabija","Kitajska","Japonska"};
    public static String[] LänderPolen ={"Niemcy", "England", "Francja", "Hiszpania", "Portugalia", "Włochy", "Dania", "Szwecja", "Norwegia", "Finlandia", "Holandia", "Turcja", "Chorwacja","Grecja","Węgry","Rosja","Czechy","Słowacja","Słowenia","Polska","Bułgaria","Arabia","Chiny","Japonia"};
    public static String[] LänderBulgarien ={"Германия", "Англия", "Франция", "Испания", "Руски", "Италия", "Дания", "Швеция", "Норвегия", "Финландия", "Холандия", "Турция", "Croatia"," Гърция "," Унгария "," Русия "," Чехия "," Словакия "," Словения "," Полша "," България "," Арабия "," Китай "," Япония "};
    public static String[] LänderArabien ={"ألمانيا", "إنجلترا", "فرنسا", "إسبانيا", "البرتغال", "إيطاليا", "الدنمارك", "السويد", "النرويج", "فنلندا", "هولندا", "تركيا", "كرواتيا "," اليونان "," المجر "," روسيا "," جمهورية التشيك "," سلوفاكيا "," سلوفينيا "," بولندا "," بلغاريا "," العربية "," الصين "," اليابان "};
    public static String[] LänderChina ={"德国","英格兰","法国","西班牙","葡萄牙","意","丹麦","瑞典","挪威","芬兰","荷兰","土耳其","克罗地亚","希腊","匈牙利","俄罗斯","捷","斯洛伐克","斯洛文尼亚","波兰","保加利亚","阿拉伯","中国","日本制造"};
    public static String[] LänderJapan ={"ドイツ","イングランド","フランス","スペイン","ポルトガル","イタリア","デンマーク","スウェーデン","ノルウェー","フィンランド","オランダ","トルコ","クロアチア","ギリシャ","ハンガリー","ロシア","チェコ","スロバキア","スロベニア","ポーランド","ブルガリア","アラビア","中国","日本"};
    
    public static void setUpItemsByLanguage() {
        switch (Locale.getDefault().getLanguage()) {
            case "de":
                LänderNutzer = LänderDeutschland;
                AllergeneNutzer = AllergeneDeutschland;
                WeiterButtonText = "Weiter";
                BeendenBText = "Beenden";
                break;
            case "en":
                LänderNutzer = LänderEngland;
                AllergeneNutzer = AllergeneEngland;
                WeiterButtonText = "Continue";
                BeendenBText = "Close";
                break;
            case "cs":
                LänderNutzer = LänderTschechien;
                AllergeneNutzer = AllergeneTschechien;
                WeiterButtonText = "další";
                BeendenBText = "zavřít";
                break;
            case "fr":
                LänderNutzer = LänderFrankreich;
                AllergeneNutzer = AllergeneFrankreich;
                WeiterButtonText = "plus loin";
                BeendenBText = "fermer";
                break;
            case "es":
                LänderNutzer = LänderSpanien;
                AllergeneNutzer = AllergeneSpanien;
                WeiterButtonText = "adicional";
                BeendenBText = "cerrar";
                break;
            case "pt":
                LänderNutzer = LänderPortugal;
                AllergeneNutzer = AllergenePortugal;
                WeiterButtonText = "mais";
                BeendenBText = "desligar";
                break;
            case "it":
                LänderNutzer = LänderItalien;
                AllergeneNutzer = AllergeneItalien;
                WeiterButtonText = "ulteriore";
                BeendenBText = "fermare";
                break;
            case "da":
                LänderNutzer = LänderDänemark;
                AllergeneNutzer = AllergeneDänemark;
                WeiterButtonText = "yderligere";
                BeendenBText = "lukke ned";
                break;
            case "sv":
                LänderNutzer = LänderSchweden;
                AllergeneNutzer = AllergeneSchweden;
                WeiterButtonText = "ytterligare";
                BeendenBText = "stänga av";
                break;
            case "no":
                LänderNutzer = LänderNorwegen;
                AllergeneNutzer = AllergeneNorwegen;
                WeiterButtonText = "videre";
                BeendenBText = "skru av";
                break;
            case "fi":
                LänderNutzer = LänderFinnland;
                AllergeneNutzer = AllergeneFinnland;
                WeiterButtonText = "edelleen";
                BeendenBText = "sulkea";
                break;
            case "nl":
                LänderNutzer = LänderNiederlande;
                AllergeneNutzer = AllergeneNiederlande;
                WeiterButtonText = "verder";
                BeendenBText = "afsluiten";
                break;
            case "tr":
                LänderNutzer = LänderTürkei;
                AllergeneNutzer = AllergeneTürkei;
                WeiterButtonText = "ayrıca";
                BeendenBText = "kapat";
                break;
            case "hr":
                LänderNutzer = LänderKroatien;
                AllergeneNutzer = AllergeneKroatien;
                WeiterButtonText = "dalje";
                BeendenBText = "ugasiti";
                break;
            case "el":
                LänderNutzer = LänderGriechenland;
                AllergeneNutzer = AllergeneGriechenland;
                WeiterButtonText = "περαιτέρω";
                BeendenBText = "τέλος";
                break;
            case "hu":
                LänderNutzer = LänderUngarn;
                AllergeneNutzer = AllergeneUngarn;
                WeiterButtonText = "további";
                BeendenBText = "vég";
                break;
            case "ru":
                LänderNutzer = LänderRussland;
                AllergeneNutzer = AllergeneRussland;
                WeiterButtonText = "дальше";
                BeendenBText = "конец";
                break;
            case "sk":
                LänderNutzer = LänderSlowakei;
                AllergeneNutzer = AllergeneSlowakei;
                WeiterButtonText = "ďalšie";
                BeendenBText = "koniec";
                break;
            case "sl":
                LänderNutzer = LänderSlowenien;
                AllergeneNutzer = AllergeneSlowenien;
                WeiterButtonText = "nadalje";
                BeendenBText = "konec";
                break;
            case "pl":
                LänderNutzer = LänderPolen;
                AllergeneNutzer = AllergenePolen;
                WeiterButtonText = "dalej";
                BeendenBText = "koniec";
                break;
            case "bg":
                LänderNutzer = LänderBulgarien;
                AllergeneNutzer = AllergeneBulgarien;
                WeiterButtonText = "още";
                BeendenBText = "край";
                break;
            case "ar":
                LänderNutzer = LänderArabien;
                AllergeneNutzer = AllergeneArabien;
                WeiterButtonText = "إضافي";
                BeendenBText = "النهاية";
                break;
            case "zh":
                LänderNutzer = LänderChina;
                AllergeneNutzer = AllergeneChina;
                WeiterButtonText = "进一步";
                BeendenBText = "结束";
                break;
            case "ja":
                LänderNutzer = LänderJapan;
                AllergeneNutzer = AllergeneJapan;
                WeiterButtonText = "さらに";
                BeendenBText = "終わり";
                break;
            default:
                LänderNutzer = LänderEngland;
                AllergeneNutzer = AllergeneEngland;
                WeiterButtonText = "Continue";
                BeendenBText = "Close";
                break;

        }

        isMarked = new boolean[21];//Number of Allergenes
        for (int i = 0; i < isMarked.length; i++) {
            isMarked[i] = false; //TODO Delete?
        }
    }

}
