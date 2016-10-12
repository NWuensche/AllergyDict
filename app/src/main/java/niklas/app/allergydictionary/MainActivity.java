package niklas.app.allergydictionary;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    Integer SpracheID = -1;
    String WeiterButtonText = "";
    String UeberItemText = "";
    ArrayList<String> Items;
    Integer InhaltArray = 1;
    LinearLayout Liste;
    String BeendenBText = "";
    boolean NichtsAusgewähltAllerge = true;

    ProgressDialog mProgressDialog;

    Thre t = new Thre();
    String LänderAuslandName;
    int AnzahlAllergene = 21;
    int[] woRot = new int[AnzahlAllergene];
    boolean ErstesmalAllergene = true;


    // TODO Datenbank
    String[] AllergeneNutzer;
    String[] AllergeneAusland;
    String[] LänderNutzer;

    String[] AllergeneDeutschland = { "Haselnuss", "Walnuss", "Erdnuss", "Paranuss", "Cashewnuss", "Macadamia", "Mandel", "Pistazie", "Gluten","Krebstiere","Ei","Fisch","Soja","Milchprodukte", "Schalenfrüchte","Sellerie","Senf","Sesam","Schwefel","Lupinen","Weichtiere"};
    String[] AllergeneEngland = {"hazelnut", "walnut", "peanut", "Brazil nut", "cashew", "macadamia", "almond", "pistachio", "gluten", "crustacean", "egg", "fish", "soy","Dairy","Nuts","Celery","Mustard","Sesame","Sulfur","Lupine","Mollusc"};
    String[] AllergeneFrankreich = {"Noisette", "noix", "arachides", "noix du Brésil", "noix de cajou", "macadamia", "amande", "pistache", "sans gluten", "crustacés", "oeuf", "poisson", "soja","les produits laitiers","Noix","Céleri","Moutarde" ,"sésame","soufre","lupin","mollusque"};
    String[] AllergeneSpanien = {"avellana", "nueces", "maní", "nuez de Brasil", "cajú", "macadamia", "almendra", "pistachos", "gluten", "crustáceos", "huevo", "pescado", "soja","Productos lácteos","Nueces","Apio","Mostaza","Sésamo","Azufre","Chocho","Moluscos"};
    String[] AllergenePortugal = {"avelã", "noz", "amendoim", "castanha do Brasil", "caju", "macadâmia", "amendoeiras", "pistachio", "glúten", "crustáceo", "ovo", "pescar", "soy","Produtos lácteos","Castanhas","Aipo","Mostarda","Gergelim","Enxofre","Tremoço","Molusco"};
    String[] AllergeneItalien = {"nocciola", "noce", "peanut", "noci del Brasile", "cashew", "macadamia", "a mandorla", "pistacchio", "glutine", "crostaceo", "uovo", "pesce", "soy","Latte","Noci","Sedano","Senape","Sesamo","Di zolfo","Lupin","Mollusco"};
    String[] AllergeneDänemark = {"hasselnød", "valnød", "peanut", "Brazil nut", "cashew", "macadamia", "mandel", "pistacie", "gluten", "krebsdyr", "æg", "fisk", "soja","Mejeri","Nuts","Selleri","Sennep","Sesam","Svovl","Lupin","Bløddyr"};
    String[] AllergeneSchweden = {"hasselnöt", "valnöt", "jordnöt", "Brasilien nöt", "cashew", "makadamianötter", "almond", "pistage", "gluten", "kräftdjur", "ägget", "fisk", "soja","Mejeri","Nötter","Selleri","Senap","Sesam","Svavel","Lupin","Blötdjur"};
    String[] AllergeneNorwegen = {"Hasselnøtter", "valnøtt", "peanut", "Brazil nut", "cashew", "macadamia", "mandel", "pistasj", "gluten", "krepsdyr", "egg", "fisk", "soya","Meieri","Nøtter","Selleri","Sennep","Sesam","Svovel","Lupin","Bløtdyr"};
    String[] AllergeneFinnland = {"hasselpähkinä", "saksanpähkinä", "maapähkinä", "Brazil nut", "cashew", "macadamia", "manteli", "pistaasi", "gluteeniton", "äyriäinen", "muna", "fish", "soy","Meijeri","Pähkinät","Selleri","Sinappia","Seesami","Rikki","Lupiini","Nilviäinen"};
    String[] AllergeneNiederlande = {"hazelnoot", "walnoot", "peanut", "Brazil nut", "cashew", "macadamia", "almond", "pistache", "gluten", "schaaldieren", "ei", "fish", "soy","Zuivel","Nuts","Selderij","Mustard","Sesame","Zwavel","Lupine","Mollusc"};
    String[] AllergeneTürkei = {"fındık", "ceviz", "fıstık", "Brezilya fıstığı", "kaju", "macadamia", "badem", "fıstık", "gluten", "kabuklu", "yumurta", "balık", "soy","Süt","Fındık","Kereviz","Hardal","Susam","Kükürt","Kurt","Yumuşakça"};
    String[] AllergeneKroatien = {"lješnjak", "oraha", "kikiriki", "Brazil orah", "kasu", "australski", "badem", "pistacija", "glutena", "rak", "Jaje", "riba", "od soje","Mliječni","Matice","Celer","Senf","Sezam","Sumpor","Lupina","Mekušaca"};
    String[] AllergeneGriechenland = {
            "φουντούκι", "καρύδι", "φυστίκι", "καρύδι Βραζιλίας", "κάσιους", "macadamia", "αμύγδαλο", "φιστίκι", "χωρίς γλουτένη", "καρκινοειδών", "αυγό", "ψάρι", "σόγια "," γαλακτοκομικά "," καρύδια "," σέλινο "," μουστάρδα "," σουσάμι "," θείο "," λούπινα "," μαλάκιο "};
    String[] AllergeneUngarn = {"mogyoró", "dió", "földimogyoró", "brazil dió", "kesudió", "macadamia", "mandula", "pisztácia", "glutén", "rákok", "tojás", "hal", "szója","Tejtermékek","Dió ","Zeller","Mustár","Szezám","Kén","Csillagfürt","Puhatestű "};
    String[] AllergeneRussland = {
                    "фундук", "грецкий орех", "арахисовое", "Бразильский орех", "кешью", "макадамии", "Миндаль", "фисташки", "клейковины", "рачок", "яйцо", "рыба", "соевый "," молочные продукты "," гайки "," сельдерей "," горчица "," кунжутное "," сера "," люпина "," моллюск "};
    String[] AllergeneTschechien = {"lískový ořech", "vlašský ořech", "arašíd", "Brazil ořech", "kešu", "macadamia", "mandle", "pistácie", "lepek", "korýš", "vejce", "ryba", "soy"," mléčné výrobky"," ořechy", "celer","hořčice","sezam","síra","vlčí bob","měkkýši"};
    String[] AllergeneSlowakei = {"lieskový orech", "vlašský orech", "arašidy", "Brazil orech", "kešu", "macadamia", "mandle", "pistácie", "lepok", "kôrovec", "vajcia", "ryba", "soy","Mliečne výrobky","Orechy","Zeler","Horčica","Sezam","Síra","Vlčí ","Mäkkýše"};
    String[] AllergeneSlowenien = {"lešnik", "oreh", "arašide", "Brazilija oreh", "indijski", "makadamija", "mandelj", "pistacija", "gluten", "raki", "jajce", "ribe", "soja","Mlečni","Orehi","Zelena","Gorčica","Sezamovo"," žvepla","Volčji bob","Mehkužcev"};
    String[] AllergenePolen = {
                    "orzech laskowy", "orzech włoski", "orzeszki ziemne", "orzech Brazil", "nerkowca", "macadamia", "migdał", "pistacjowy", "gluten", "skorupiak", "jajko", "ryba", "sojowego","Mleczarnia","Orzechy","Seler","Musztarda","Sezam","Siarka","Wilczy","Mięczaków"};
    String[] AllergeneBulgarien = {"лешник", "орех", "фъстъчен", "Бразилия гайка", "кашу", "макадамия", "бадем", "шам-фъстък", "без глутен", "ракообразно", "яйце", "риба", "соев "," млечни продукти "," ядки "," целина "," горчица "," сусам "," серен "," вълчи "," мекотели "};
    String[] AllergeneArabien = {"بندق", "خشب الجوز", "الفول السوداني", "البرازيل الجوز", "الكاجو", "المكاديميا", "اللوز", "الفستق", "الغلوتين", "القشريات", "البيضة", "الأسماك", "الصويا "," منتجات الألبان "," المكسرات "," الكرفس "," الخردل "," السمسم "," الكبريت "," الترمس "," الرخويات "};
    String[] AllergeneChina = {"榛子","核桃","花生","巴西果","腰果","夏威夷","杏仁","开心果","面筋","甲壳","蛋","鱼","酱油","乳制品","坚果","芹菜","榨菜","芝麻","硫磺","鲁冰花","软体动物"};
    String[] AllergeneJapan = {"ヘーゼルナッツ","ウォールナット","ピーナッツ","ブラジルナッツ","カシュー","マカダミア","アーモンド","ピスタチオ","グルテン","甲殻類","たまご","魚","大豆","乳製品","ナッツ","セロリ","マスタード","ゴマ","硫黄","ルピナス","軟体動物"};

    String[] LänderDeutschland = { "Deutschland","England","Frankreich","Spanien","Portugal", "Italien","Dänemark","Schweden", "Norwegen", "Finnland", "Niederlande","Türkei", "Kroatien","Griechenland","Ungarn", "Russland", "Tschechien", "Slowakei", "Slowenien", "Polen",  "Bulgarien","Arabien", "China", "Japan"};
    String[] LänderEngland ={"Germany", "England", "France", "Spain", "Portugal", "Italy", "Denmark", "Sweden", "Norway", "Finland", "Netherlands", "Turkey", "Croatia","Greece","Hungary","Russia","Czech Republic","Slovakia","Slovenia","Poland","Bulgaria","Arabia","China","Japan"};
    String[] LänderFrankreich ={"Allemagne", "l'Angleterre", "France", "Espagne", "Portugal", "Italie", "le Danemark", "La Suède", "la Norvège", "la Finlande", "Pays-Bas", "la Turquie", "Croatie","Grèce","Hongrie","Russie","République tchèque","Slovaquie","Slovénie","La Pologne","La Bulgarie","Arabia","Chine","Japon"};
    String[] LänderSpanien ={
            "Alemania", "Inglaterra", "Francia", "España", "Portugal", "Italia", "Dinamarca", "Suecia", "Noruega", "Finlandia", "Países Bajos", "Turquía", "Croacia","Grecia","Hungría","Rusia","República Checa","Eslovaquia","Eslovenia","Polonia","Bulgaria","Arabia","China","Japón"};
    String[] LänderPortugal ={"Alemanha", "Inglaterra", "França", "Spain", "Portugal", "Itália", "Dinamarca", "Suécia", "Noruega", "Finlândia", "Países Baixos", "turquia", "Croatia","Grécia","Hungria","Rússia","República Checa","Eslováquia","Slovenia","Polónia","Bulgária","Arábia","China","Japão"};
    String[] LänderItalien ={"Germania", "England", "Francia", "Spain", "Portugal", "Italia", "la Danimarca", "Svezia", "Norvegia", "Finlandia", "Paesi Bassi", "Turchia", "Croazia","Grecia","L'Ungheria","Russia","Repubblica Ceca","Slovacchia","Slovenia","La Polonia","Bulgaria","Arabia","Cina","Japan"};
    String[] LänderDänemark ={"Tyskland", "England", "France", "Spanien", "Portugal", "Italien", "Danmark", "Sverige", "Norge", "Finland", "Holland", "Tyrkiet", "Kroatien","Grækenland","Ungarn","Rusland","Tjekkiet","Slovakiet","Slovenien","Polen","Bulgarien","Arabia","China","Japan"};
    String[] LänderSchweden ={
            "Tyskland", "England", "Frankrike", "Spanien", "Portugal", "Italien", "Danmark", "Sverige", "Norge", "Finland", "Nederländerna", "Turkiet", "Kroatien","Grekland","Ungern","Ryssland","Tjeckien","Slovakien","Slovenien","Polen","Bulgarien","Arabien","Kina","Japan"};
    String[] LänderNorwegen ={
            "Germany", "England", "Frankrike", "Spain", "Portugal", "Italia", "Danmark", "Sverige", "Norge", "Finland", "Nederland", "Turkey", "Kroatia","Hellas","Ungarn","Russland","Tsjekkia","Slovakia","Slovenia","Polen","Bulgaria","Arabia","China","Japan"};
    String[] LänderFinnland ={"Saksa", "England", "France", "Espanja", "Portugali", "Italia", "Denmark", "Ruotsi", "Norja", "Suomi", "Alankomaat", "Turkki", "Croatia","Kreikka","Unkari","Venäjä ","Tšekki","Slovakia","Slovenia","Puola","Bulgaria","Arabian","Kiina","Japan"};
    String[] LänderNiederlande ={
            "Duitsland", "Engeland", "Frankrijk", "Spanje", "Portugal", "Italië", "Denemarken", "Zweden", "Noorwegen", "Finland", "Nederland", "Turkije", "Kroatië ","Griekenland","Hongarije","Rusland","Tsjechië ","Slowakije","Slovenië ","Polen","Bulgarije","Arabia","China","Japan"};
    String[] LänderTürkei ={"Almanya", "İngiltere", "Fransa", "Spain", "Portekiz", "İtalya", "Danimarka", "İsveç", "Norveç", "Finlandiya", "Hollanda", "Türkiye", "Hırvatistan","Yunanistan","Macaristan","Rusya"," Çek Cumhuriyeti","Slovakya","Slovenya","Polonya","Bulgaristan","Arabistan"," Çin","Japonya"};
    String[] LänderKroatien ={"Njemačka", "Engleska", "Francuska", "Španjolska", "Portugal", "Italija", "Danska", "Švedska", "Norveška", "Finska", "Nizozemska", "Turska", "Hrvatska","Grčka","Mađarska","Rusija"," Češka Republika","Slovačka","Slovenija","Poljska","Bugarska","Arabije","Kina","Japan"};
    String[] LänderGriechenland ={"Γερμανία", "Αγγλία", "Γαλλία", "Ισπανία", "Πορτογαλία", "Ιταλία", "Δανία", "Σουηδία", "Νορβηγία", "Φινλανδία", "Κάτω", "Τουρκία", "Κροατία "," Η Ελλάδα "," Ουγγαρία "," Ρωσία "," Τσεχική Δημοκρατία "," Σλοβακία "," Σλοβενία "," Πολωνία "," Βουλγαρία "," Αραβία "," η Κίνα "," Ιαπωνία "};
    String[] LänderUngarn ={
            "Németország", "England", "Franciaország", "Spanyolország", "Portugália", "Olaszország", "Dánia", "Svédország", "Norvégia", "Finnország", "Hollandia", "Törökország", "Horvátország","Görögország","Magyarország","Oroszország","Csehország","Szlovákia","Szlovénia","Kengyelország","Bulgária","Arábia","Kína","Japán"};
    String[] LänderRussland ={"Германия", "Англия", "Франция", "Испания", "Португалия", "Италия", "Дания", "Швеция", "Норвегия", "Финляндия", "Нидерланды", "Турция", "Хорватия "," Греция "," Венгрия "," Россия "," Чехия "," Словакия "," Словения "," Польша "," Болгария "," Аравия "," Китай "," Япония "};
    String[] LänderTschechien = {"Německo", "Anglie", "Francie", "Španělsko", "Portugalsko", "Itálie", "Dánsko", "Švédsko", "Norsko", "Finsko", "Nizozemsko", "Turecko", "Chorvatsko", "Řecko","Maďarsko","Rusko","česká republika","Slovensko","Slovinsko","Polsko","Bulharsko","Arábie","Čína","Japan"};
    String[] LänderSlowakei ={"Nemecko", "Anglicko", "Francúzsko", "Španielsko", "Portugalsko", "Taliansko", "Dánsko", "Švédsko", "Nórsko", "Fínsko", "Holandsko", "Turecko", "Chorvátsko","Grécko","Maďarsko","Rusko"," Česká republika","Slovensko","Slovinsko","Poľsko","Bulharsko","Arábia"," Čína","Japan"};
    String[] LänderSlowenien ={"Nemčija", "England", "Francija", "Španija", "Portugalska", "Italija", "Danska", "Švedska", "Norveška", "Finska", "Nizozemska", "Turčija", "Hrvaška","Grčija","Madžarska","Rusija"," Češka","Slovaška","Slovenija","Poljska","Bolgarija","Arabija","Kitajska","Japonska"};
    String[] LänderPolen ={"Niemcy", "England", "Francja", "Hiszpania", "Portugalia", "Włochy", "Dania", "Szwecja", "Norwegia", "Finlandia", "Holandia", "Turcja", "Chorwacja","Grecja","Węgry","Rosja","Czechy","Słowacja","Słowenia","Polska","Bułgaria","Arabia","Chiny","Japonia"};
    String[] LänderBulgarien ={"Германия", "Англия", "Франция", "Испания", "Руски", "Италия", "Дания", "Швеция", "Норвегия", "Финландия", "Холандия", "Турция", "Croatia"," Гърция "," Унгария "," Русия "," Чехия "," Словакия "," Словения "," Полша "," България "," Арабия "," Китай "," Япония "};
    String[] LänderArabien ={"ألمانيا", "إنجلترا", "فرنسا", "إسبانيا", "البرتغال", "إيطاليا", "الدنمارك", "السويد", "النرويج", "فنلندا", "هولندا", "تركيا", "كرواتيا "," اليونان "," المجر "," روسيا "," جمهورية التشيك "," سلوفاكيا "," سلوفينيا "," بولندا "," بلغاريا "," العربية "," الصين "," اليابان "};
    String[] LänderChina ={"德国","英格兰","法国","西班牙","葡萄牙","意","丹麦","瑞典","挪威","芬兰","荷兰","土耳其","克罗地亚","希腊","匈牙利","俄罗斯","捷","斯洛伐克","斯洛文尼亚","波兰","保加利亚","阿拉伯","中国","日本制造"};
    String[] LänderJapan ={"ドイツ","イングランド","フランス","スペイン","ポルトガル","イタリア","デンマーク","スウェーデン","ノルウェー","フィンランド","オランダ","トルコ","クロアチア","ギリシャ","ハンガリー","ロシア","チェコ","スロバキア","スロベニア","ポーランド","ブルガリア","アラビア","中国","日本"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Liste = (LinearLayout) findViewById(R.id.ListeID);
        Liste.setGravity(View.TEXT_ALIGNMENT_CENTER);

        t.execute();


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            switch (Locale.getDefault().getLanguage()) {
                case "de":
                    builder.setTitle("Haftungsausschluss")
                            .setMessage("Es gibt keine Garantie, dass diese App 100% richtig ist. Durch das Nutzen dieser App akzeptierst du, dass dies kein Problem ist.")
                            .setPositiveButton("Ich akzeptiere", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .create().show();
                    break;
                default:
                    builder.setTitle("Disclaimer")
                            .setMessage("There is no warrenty that this app is 100% right. By using this app, you agree that this is no problem.")
                            .setPositiveButton("I Agree", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .create().show();
                    break;

        }
    }




    void setwoRotNull(){
        // TODO Wenn Handy drehen, dann nicht neue Länder
        for(int i = 0; i<woRot.length; i++){
            woRot[i] = 0;
        }
    }

    void setArrayListLänder(){
        Items.clear();
        setwoRotNull();

        Liste.removeAllViews();

        switch(Locale.getDefault().getLanguage()){
            case "de":
                LänderNutzer = LänderDeutschland;
                AllergeneNutzer = AllergeneDeutschland;
                WeiterButtonText = "Weiter";
                UeberItemText = "Über";
                BeendenBText = "Beenden";
                break;
            case "en":
                LänderNutzer = LänderEngland;
                AllergeneNutzer = AllergeneEngland;
                WeiterButtonText = "Continue";
                UeberItemText = "About";
                BeendenBText = "Close";
                break;
            case "cs":
                LänderNutzer = LänderTschechien;
                AllergeneNutzer = AllergeneTschechien;
                WeiterButtonText = "další";
                UeberItemText = "o";
                BeendenBText = "zavřít";
                break;
            case "fr":
                LänderNutzer = LänderFrankreich;
                AllergeneNutzer = AllergeneFrankreich;
                WeiterButtonText = "plus loin";
                UeberItemText = "sur";
                BeendenBText = "fermer";
                break;
            case "es":
                LänderNutzer = LänderSpanien;
                AllergeneNutzer = AllergeneSpanien;
                WeiterButtonText = "adicional";
                UeberItemText = "Acerca de";
                BeendenBText = "cerrar";
                break;
            case "pt":
                LänderNutzer = LänderPortugal;
                AllergeneNutzer = AllergenePortugal;
                WeiterButtonText = "mais";
                UeberItemText = "Cerca de";
                BeendenBText = "desligar";
                break;
            case "it":
                LänderNutzer = LänderItalien;
                AllergeneNutzer = AllergeneItalien;
                WeiterButtonText = "ulteriore";
                UeberItemText = "Di";
                BeendenBText = "fermare";
                break;
            case "da":
                LänderNutzer = LänderDänemark;
                AllergeneNutzer = AllergeneDänemark;
                WeiterButtonText = "yderligere";
                UeberItemText = "Ca";
                BeendenBText = "lukke ned";
                break;
            case "sv":
                LänderNutzer = LänderSchweden;
                AllergeneNutzer = AllergeneSchweden;
                WeiterButtonText = "ytterligare";
                UeberItemText = "om";
                BeendenBText = "stänga av";
                break;
            case "no":
                LänderNutzer = LänderNorwegen;
                AllergeneNutzer = AllergeneNorwegen;
                WeiterButtonText = "videre";
                UeberItemText = "omtrent";
                BeendenBText = "skru av";
                break;
            case "fi":
                LänderNutzer = LänderFinnland;
                AllergeneNutzer = AllergeneFinnland;
                WeiterButtonText = "edelleen";
                UeberItemText = "noin";
                BeendenBText = "sulkea";
                break;
            case "nl":
                LänderNutzer = LänderNiederlande;
                AllergeneNutzer = AllergeneNiederlande;
                WeiterButtonText = "verder";
                UeberItemText = "over";
                BeendenBText = "afsluiten";
                break;
            case "tr":
                LänderNutzer = LänderTürkei;
                AllergeneNutzer = AllergeneTürkei;
                WeiterButtonText = "ayrıca";
                UeberItemText = "yaklaşık";
                BeendenBText = "kapat";
                break;
            case "hr":
                LänderNutzer = LänderKroatien;
                AllergeneNutzer = AllergeneKroatien;
                WeiterButtonText = "dalje";
                UeberItemText = "o";
                BeendenBText = "ugasiti";
                break;
            case "el":
                LänderNutzer = LänderGriechenland;
                AllergeneNutzer = AllergeneGriechenland;
                WeiterButtonText = "περαιτέρω";
                UeberItemText = "σχετικά με";
                BeendenBText = "τέλος";
                break;
            case "hu":
                LänderNutzer = LänderUngarn;
                AllergeneNutzer = AllergeneUngarn;
                WeiterButtonText = "további";
                UeberItemText = "körülbelül";
                BeendenBText = "vég";
                break;
            case "ru":
                LänderNutzer = LänderRussland;
                AllergeneNutzer = AllergeneRussland;
                WeiterButtonText = "дальше";
                UeberItemText = "около";
                BeendenBText = "конец";
                break;
            case "sk":
                LänderNutzer = LänderSlowakei;
                AllergeneNutzer = AllergeneSlowakei;
                WeiterButtonText = "ďalšie";
                UeberItemText = "O";
                BeendenBText = "koniec";
                break;
            case "sl":
                LänderNutzer = LänderSlowenien;
                AllergeneNutzer = AllergeneSlowenien;
                WeiterButtonText = "nadalje";
                UeberItemText = "O";
                BeendenBText = "konec";
                break;
            case "pl":
                LänderNutzer = LänderPolen;
                AllergeneNutzer = AllergenePolen;
                WeiterButtonText = "dalej";
                UeberItemText = "O";
                BeendenBText = "koniec";
                break;
            case "bg":
                LänderNutzer = LänderBulgarien;
                AllergeneNutzer = AllergeneBulgarien;
                WeiterButtonText = "още";
                UeberItemText = "около";
                BeendenBText = "край";
                break;
            case "ar":
                LänderNutzer = LänderArabien;
                AllergeneNutzer = AllergeneArabien;
                WeiterButtonText = "إضافي";
                UeberItemText = "حول";
                BeendenBText = "النهاية";
                break;
            case "zh":
                LänderNutzer = LänderChina;
                AllergeneNutzer = AllergeneChina;
                WeiterButtonText ="进一步";
                UeberItemText = "大约";
                BeendenBText = "结束";
                break;
            case "ja":
                LänderNutzer = LänderJapan;
                AllergeneNutzer = AllergeneJapan;
                WeiterButtonText = "さらに";
                UeberItemText = "約";
                BeendenBText = "終わり";
                break;
            default:
                LänderNutzer = LänderEngland;
                AllergeneNutzer = AllergeneEngland;
                WeiterButtonText = "Continue";
                UeberItemText = "About";
                BeendenBText = "Close";
                break;
        }

        for(String s : LänderNutzer){
            Items.add(s);
        }

    }

    void setArrayList(){
        if(InhaltArray == 1){
            setArrayListLänder();
        }
        else if(InhaltArray == 2){
            setArrayListItems();
        }
        else if (InhaltArray == 3){
            setArrayListAusland();
        }
    }

    void setArrayListAusland(){
        Items.clear();
        Liste.removeAllViews();
        int id = 0;
        switch(SpracheID){
            case 0:
                AllergeneAusland = AllergeneDeutschland;
                break;
            case 1:
                AllergeneAusland = AllergeneEngland;
                break;
            case 2:
                AllergeneAusland = AllergeneFrankreich;
                break;
            case 3:
                AllergeneAusland = AllergeneSpanien;
                break;
            case 4:
                AllergeneAusland = AllergenePortugal;
                break;
            case 5:
                AllergeneAusland = AllergeneItalien;
                break;
            case 6:
                AllergeneAusland = AllergeneDänemark;
                break;
            case 7:
                AllergeneAusland = AllergeneSchweden;
                break;
            case 8:
                AllergeneAusland = AllergeneNorwegen;
                break;
            case 9:
                AllergeneAusland = AllergeneFinnland;
                break;
            case 10:
                AllergeneAusland = AllergeneNiederlande;
                break;
            case 11:
                AllergeneAusland = AllergeneTürkei;
                break;
            case 12:
                AllergeneAusland = AllergeneKroatien;
                break;
            case 13:
                AllergeneAusland = AllergeneGriechenland;
                break;
            case 14:
                AllergeneAusland = AllergeneUngarn;
                break;
            case 15:
                AllergeneAusland = AllergeneRussland;
                break;
            case 16:
                AllergeneAusland = AllergeneTschechien;
            case 17:
                AllergeneAusland = AllergeneSlowakei;
                break;
            case 18:
                AllergeneAusland = AllergeneSlowenien;
                break;
            case 19:
                AllergeneAusland = AllergenePolen;
                break;
            case 20:
                AllergeneAusland = AllergeneBulgarien;
                break;
            case 21:
                AllergeneAusland = AllergeneArabien;
                break;
            case 22:
                AllergeneAusland = AllergeneChina;
                break;
            case 23:
                AllergeneAusland = AllergeneJapan;
                break;
            default:
                AllergeneAusland = AllergeneEngland;
        }
        String sPuffer = "";
            for (String s : AllergeneAusland) {  // TODO LänderAusland
                if (woRot[id] == 1) {

                    Items.add(s + "  (" + AllergeneNutzer[id] + ")");// TODO eigenene Ländernamen rein
                    //TODO Farben Pastell

                }
                id++;
            }
    }



    void setArrayListItems() {
        Items.clear();
        setwoRotNull();
        Liste.removeAllViews();
        // TODO Untergruppen alphabetisch ordnen
        // TODO Mehrfachauswahl
        // TODO Sprache --> Anderes Zeug in Array

        for (String s : AllergeneNutzer) {
            Items.add(s);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        else if (id == R.id.action_ueber){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setTitle(UeberItemText)
                    .setMessage("Font by  Adobe: http://www.fontsquirrel.com/fonts/source-sans-pro \n Logo by")
                    .setPositiveButton("Back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .create().show();
        }

        return super.onOptionsItemSelected(item);
    }

    class Thre extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("Allergy");
            mProgressDialog.setMessage("Laden...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Items = new ArrayList<String>();
            setArrayList();

              // TODO machen      Ueber.setTitle(UeberItemText);

            Typeface Schrift = Typeface.createFromAsset(getAssets(),"SourceSansPro-Regular.ttf");

            if(!ErstesmalAllergene & InhaltArray != 3) {
                Button WeiterB = new Button(getApplicationContext());
                WeiterB.setText(WeiterButtonText);


                WeiterB.setBackgroundResource(R.drawable.roundcornersbutton);
                WeiterB.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                WeiterB.setTypeface(Schrift);
                WeiterB.setTextSize(30);
                WeiterB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO neues Fenster mit Übersetzung + Deutsch
                        for(int i = 0 ; i<woRot.length;i++){
                            if(woRot[i] == 1){
                                NichtsAusgewähltAllerge = false;
                                InhaltArray = 3;
                                Thre t2 = new Thre();
                                t2.execute();
                                break;
                            }
                        }

                        if(NichtsAusgewähltAllerge) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            LayoutInflater inflater = MainActivity.this.getLayoutInflater();

                            switch (Locale.getDefault().getLanguage()) {
                                case "de":
                                    builder.setTitle("Fehler")
                                            .setMessage("Wählen sie mindestens ein Allergen aus.")
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {

                                                }
                                            })
                                            .create().show();
                                    break;
                                default:
                                    builder.setTitle("Error")
                                            .setMessage("Select atleast one allergen")
                                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {

                                                }
                                            })
                                            .create().show();
                                    break;
                            }
                        }


                    }
                });
                Liste.addView(WeiterB);

                Button LandB = new Button(getApplicationContext());
                LandB.setText(LänderAuslandName);
                LandB.setBackgroundResource(R.drawable.roundcornersbutton);
                LandB.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                LandB.setTypeface(Schrift);
                LandB.setTextSize(30);

            }
            if(InhaltArray == 3){
                Button BeendenB = new Button(getApplicationContext());
                BeendenB.setText(BeendenBText); // TODO In Sprache


                BeendenB.setBackgroundResource(R.drawable.roundcornersbutton);
                BeendenB.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                BeendenB.setTypeface(Schrift);
                BeendenB.setTextSize(30);
                BeendenB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO neues Fenster mit Übersetzung + Deutsch
                        System.exit(0);
                    }
                });
                Liste.addView(BeendenB);
            }
            Button UeberB = new Button(getApplicationContext());
            UeberB.setText(UeberItemText);
            //TODO wenn kein Allergen ausgewählt


            UeberB.setBackgroundResource(R.drawable.roundcornersbutton);
            UeberB.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            UeberB.setTypeface(Schrift);
            UeberB.setTextSize(30);
            UeberB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    LayoutInflater inflater = MainActivity.this.getLayoutInflater();

                    builder.setTitle(UeberItemText)
                            .setMessage("Font by  Adobe: http://www.fontsquirrel.com/fonts/source-sans-pro \n Logo by")
                            .setPositiveButton("Back", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .create().show();

                }
            });

            int id = 0;

            for(String s : Items){
                final TextView TextV = new TextView(getApplicationContext());
                TextV.setText(s);
                TextV.setTextColor(Color.WHITE);
                TextV.setTextSize(30);
                final int id2 = id;

                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);
                TextV.setWidth(metrics.widthPixels);
                TextV.setTypeface(Schrift);
                TextV.setBackgroundResource(R.drawable.roundcorners);
                TextV.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                Liste.addView(TextV);
                TextV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (InhaltArray == 2) {
                            if (TextV.getCurrentTextColor() == Color.RED) {
                                TextV.setTextColor(Color.WHITE);
                                woRot[id2] = 0;
                            } else {
                                TextV.setTextColor(Color.RED);
                                woRot[id2] = 1;
                            }
                        }
                        InhaltArray = 2;
                        if (ErstesmalAllergene) {


                            Thre t1 = new Thre();
                            t1.execute();
                            LänderAuslandName = TextV.getText().toString();
                            SpracheID = id2; // TODO geht das?
                            ErstesmalAllergene = false;
                        }

                    }
                });
                id++;

            }

            mProgressDialog.dismiss();

        }
    }
}
