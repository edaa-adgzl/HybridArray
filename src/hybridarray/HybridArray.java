
package hybridarray;


import java.util.Scanner; //Kavyeden veri okumaya yarayan koddur..


public class HybridArray {

    

    static int hybridArray[];
    static int boyut;
    static int kapasite = 100;
    
    
    
    public HybridArray(){   //Default constructor
       hybridArray = new int[kapasite];
    }
    
    public void addLast(int n){     //Dizinin sonuna yazılan elemanı eklemeye yarayan koddur.
        
        if (boyut == kapasite) {    //Dizinin kapasitesini kontrol edicez burada.
            resize();
        }
        hybridArray[boyut] = n;     
        boyut++;                    
    }
    
    public void addFirst(int n){    //Dizinin başına yazılan elemanı eklemeye yarayan koddur.
        boyut++;
        if (boyut == kapasite) {    //Dizinin kapasitesini kontrol edicez burada.
            resize();
        }
        
        for (int i = boyut-1; i >= 0; i--) {    
            hybridArray[i+1] = hybridArray[i];
        }
        //Dizinin ilk elemanını boşaltmak için sondan başlayarak
        //her elemanı 1 defa kaydırıyoruz.
        hybridArray[0] = n;
    }
    
    public void insert(int n, int index){ //Belirlenen index'e yazılan elemanı girmeye yarayan koddur.
        if (boyut == kapasite) {    //Dizinin kapasitesini kontrol edicez burada.
            resize();
        }
        boyut++;
        for (int i = boyut; i >= index; i--) {
            hybridArray[i+1] = hybridArray[i];
        }
        /*
        Belirlenen index'i boşaltmak için ondan sonraki her elemanı
        bir defa  kaydırıyoruz.
        */
        hybridArray[index] = n;
    }
    
    public void removeFirst(){  //Dizinin ilk elemanını silmeye yarayan koddur.
        for (int i = 0; i < boyut; i++) {
            hybridArray[i] = hybridArray[i+1];
        }
        //Her elemanı bir önceki elemanın üstüne yazarak ilk elemanın silinmesini sağlıcaz burada.
        boyut--;
    }
    
    public void removeLast(){ //Dizinin son elemanını silmeye yarayan koddur.
        boyut--;
        int [] HybridArrayTemp = new int [boyut]; 
        //Boyutunu bir azalttığımız yeni bir dizi oluşturucaz.
        for (int i = 0; i < boyut; i++) {
            HybridArrayTemp[i] = hybridArray[i];
        }
        /*
        Oluşturduğumuz yeni dizinin içine asıl dizinin elemanlarını yazıcaz burada.
        Boyutu daha küçük olduğu için son elemanı kesinlikle almıyoruz.
        */
        hybridArray = HybridArrayTemp;
        //Yeni diziyi eski dizinin üzerine yazıcaz burada.
    }
    
    public void removeAt(int index){    //Belirlenen index'teki elemanı silmeye yarayan koddur.
        for (int i = index; i < boyut-1; i++) {
            hybridArray[i] = hybridArray[i+1];
        }
        /*
        Belirlenen index'ten sonraki her elemanı bir önceki elemanın üzerine 
        yazarak belirlenen elemanı kesinlikle silmiyoruz.
        */
        boyut--;
    }
    
    public int get(int index){  //Belirlenen indexteki veriyi döndürür.
        
        return hybridArray[index];
        
    }
    
    public void clear(){    //Dizinin bütün elemanlarını silmeye yarayan koddur.
        int [] newHybridArray = new int [kapasite];
        hybridArray = newHybridArray;
        /*
        Varsayılan kapasitede bir dizi oluşturarak asıl dizinin üzerine 
        yazıcaz.
        */
        boyut = 0;
    }
    
    public int size(){ //Dizinin eleman sayısını döndürmeye yarayan koddur.
        return boyut;
    }
    
    public void println(){ //Dizinin elemanlarını ekrana yazmaya yarayan koddur.
        if (boyut!=0) { //Dizide eleman olduğunu kontrol ediyoruz.
        System.out.println(""); 
        //Okunulurluğu arttırmak için bir satır aşağı iniyoruz.
        System.out.print("Dizide ki elemanlar: ");
        for (int i = 0; i < boyut-1; i++) {
            System.out.print(hybridArray[i]+",");
        }
        /*
        Son eleman dışında her elemanı aralarına virgül gelecek şekilde
        döngü yardımıyla kesinlikle yazmamız gerekiyor.
        */
        System.out.println(hybridArray[boyut-1]);
        //Son elemanı manuel yazıyoruz ki Son elemandan sonra virgül koymasın
        
        }else{
            System.out.println("Dizi boş.");
        }
        //Dizi boşsa ekrana "Dizi boştur"yazıyoruz.
    }
    
    public void resize() { //Dizinin kapasitesini ikiye katlamaya yarayan koddur.
        int [] NewHybridArray = new int[kapasite*2];
        //Kapasitesi iki kat büyük yeni bir dizi oluşturucaz.
        for (int i = 0; i < boyut; i++) {
            NewHybridArray[i] = hybridArray[i];
        }
        //Asıl dizinin her bir elemanını yeni diziye aktarıcaz burada.
        hybridArray = NewHybridArray;
        //Yeni diziyi Asıl dizinin üzerine yazıcaz burada.
    }
    
    public static void main(String[] args) {
        HybridArray hybrid = new HybridArray();
         Scanner girdi = new Scanner(System.in);
        int secim = 0;
        boolean döngü = true;
        int girilenSayi = 0;
        int girilenIndex = 0;
        System.out.println("Dizi oluşturuldu.");
        Secim:
        while(döngü){
            //Kullanıcıya yapacağı işlemi sorucaz burada.
            System.out.println("Lütfen yapmak istediğiniz işlemi giriniz.");
            System.out.println("1-Veri Ekle");
            System.out.println("2-Veri Sil");
            System.out.println("3-Veri Oku");
            System.out.println("4-Diziyi Temizle");
            System.out.println("5-Dizi Boyutunu Sorgula");
            System.out.println("6-Diziyi Yazdır");
            System.out.println("7-Çıkış");
            
            secim = girdi.nextInt();
            
            switch(secim){
                case 1:
                    //Hangi yöntemle veri ekleneceğini soruyocaz burada.
                    System.out.println("Veri ekleme yöntemi seçiniz:");
                    System.out.println("1-Dizinin Sonuna Ekle.");
                    System.out.println("2-Dizinin Başına Ekle.");
                    System.out.println("3-İndex Girerek Ekle");
                    secim=girdi.nextInt();
                    switch(secim){
                        case 1:
                            System.out.print("Diziye eklenecek sayıyı giriniz: ");
                            girilenSayi = girdi.nextInt();
                            hybrid.addLast(girilenSayi);
                            System.out.println(girilenSayi+" sayısı dizinin sonuna eklendi.");
                            continue Secim;
                        case 2:
                            System.out.print("Diziye eklenecek sayıyı giriniz: ");
                            girilenSayi = girdi.nextInt();
                            hybrid.addFirst(girilenSayi);
                            System.out.println(girilenSayi+" sayısı dizinin başına eklendi.");
                            continue Secim;
                        case 3:
                            System.out.print("Diziye eklenecek sayıyı giriniz: ");
                            girilenSayi = girdi.nextInt();
                            System.out.print("Eklemek istediğiniz index'i giriniz: ");
                            girilenIndex = girdi.nextInt();
                            System.out.println(girilenSayi+" sayısı"+girilenIndex+" index'ine eklendi.");
                            continue Secim;
       
                    }
                    continue Secim;
                case 2:
                    //Hangi yöntemle veri silineceğini sorucaz burada.
                    System.out.println("Veri silme yöntemi seçiniz:");
                    System.out.println("1-Dizinin Sonundan Sil.");
                    System.out.println("2-Dizinin Başından Sil.");
                    System.out.println("3-İndex Girerek Sil");
                    secim=girdi.nextInt();
                    switch(secim){
                        case 1:
                            girilenSayi = hybrid.get(hybrid.size());
                            hybrid.removeLast();
                            System.out.println(girilenSayi+" sayısı dizinin sonundan silindi.");
                            continue Secim;
                        case 2:
                            girilenSayi = hybrid.get(0);
                            hybrid.removeFirst();
                            System.out.println(girilenSayi+" sayısı dizinin başından silindi.");
                            continue Secim;
                        case 3:
                            System.out.print("Silmek istediğiniz index'i giriniz: ");
                            girilenIndex = girdi.nextInt();
                            girilenSayi = hybrid.get(girilenIndex);
                            System.out.println(girilenSayi+" sayısı"+girilenIndex+" index'inden silindi");
                            continue Secim;
       
                    }
                    continue Secim;
                case 3:
                    
                    System.out.print("Okumak istediğiniz verinin index'ini giriniz: ");
                    girilenIndex = girdi.nextInt();
                    System.out.println(girilenIndex+" index'indeki sayı = "+hybrid.get(girilenIndex));
                    
                    continue Secim;
                    
                case 4:
                    
                    hybrid.clear();
                    System.out.println("Dizi temizlendi.");
                    
                    continue Secim;
                    
                case 5:
                    
                    System.out.println("Dizinin boyutu = "+ (hybrid.size())+1);
                    
                    continue Secim;
                    
                case 6:
                    
                    hybrid.println();
                    
                    
                    continue Secim;
                
                case 7:
                    döngü = false;
                break;
                    
            }
        }
        
    }

    
}
