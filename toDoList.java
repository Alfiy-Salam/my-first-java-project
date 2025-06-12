public class toDoList{

  public static String[] model = new String[10];
  public static java.util.Scanner scanner = new java.util.Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("\n===To Do List===\n");
    viewShowToDoList();
  }

  /** Menu to do list **/
  public static void showTodoList() {
    System.out.println("\n===To Do List===");

    // Perulangan untuk nomor To Do List
    for (Integer i = 0; i < model.length; i++) {
      // Di gunakan untuk mencetak nomor
      Integer nomer = i + 1;
      String todo = model[i];
      /*
       * Jika "model[i]" (elemen pada indeks saat ini) tidak null (berisi nilai), maka dicetak.
       * Jika null (kosong), maka baris ini dilewati dan tidak dicetak.
       */
      if (model[i] != null) {
        System.out.println(nomer + ". " + todo);
      }
    }

  }

  /** Menambahkan to do list **/
  public static void addTodoList(String todo) {
    // Menambahkan data ke array nya kosong
    for (Integer i = 0; i < model.length; i++) {
      if (model[i] == null) {
        model[i] = todo;
        break;
      }
    }

    // Cek "model" penuh atau tidak
    var isFull = true;
    for (Integer i = 0; i < model.length; i++) {
      if (model[i] == null) {
        isFull = false;
        break;
      }
    }

    // Jika penuh, kita resize ukuran array "model" jadi 2x
    if (isFull) {
      var temp = model;
      model = new String[temp.length * 2];

      for (int i = 0; i < temp.length; i++) {
        model[i] = temp[i];
      }
    }
  }

  /** Menghapus to do list **/
  public static boolean removeTodoList(Integer notodo) {
    if ((notodo - 1) >= model.length) {
      return false;
    } else if (model[notodo - 1] == null) {
      return false;
    } else {
        for (Integer i = (notodo-1); i < model.length; i++){
            if (i == (model.length-1)){
                model[i] = null;
            } else {
                model[i] = model[i+1];
            }
        }

      return true;
    }
  }

  /** Menampilkan menu to do list **/
  public static void viewShowToDoList() {
    System.out.println("Menu To Do List Apps");
    System.out.println("1. Tambah");
    System.out.println("2. Hapus");
    System.out.println("3. Keluar");

    System.out.print("Masukan pilihanmu: ");
    Boolean inputAngka = true;
    while (inputAngka) {
      try {
        Integer choiceInput = Integer.valueOf(input());
        if (choiceInput == 1) {
          viewAddToDoList();
          return;
        } else if (choiceInput == 2) {
          viewRemoveToDoList();
          return;
        } else if (choiceInput == 3) {
          return;
        } else{
          System.out.println("Bro lihat menu lah!");
          System.out.print("Masukan pilihanmu: ");
        }
      } catch (NumberFormatException e) {
        System.out.println("Hadeuh Bro... Inputnya tuh hanya "+ "1, 2, dan 3!");
        System.out.print("Masukan pilihanmu: ");
      }
    }
  }

  /** Menampilkan add to do list **/
  public static void viewAddToDoList() {
      System.out.println("\n===Tampilan Penambahan To Do List===");
      System.out.print("Masukan To Do List: ");
      String inputUser = String.valueOf(input());
      addTodoList(inputUser);
      showTodoList();
      System.out.println("\n");
      viewShowToDoList();

  }

  /** Menampilkan remove to do list **/
  public static void viewRemoveToDoList() {
      System.out.println("\n===Tampilan Hapus To Do List");
      System.out.print("Masukan Nomor: ");
      Integer inputUser = Integer.valueOf(input());
      removeTodoList(inputUser);
      showTodoList();
      System.out.println("\n");
      viewShowToDoList();
  }

  /** Scanner input dari User **/
  public static String input() {
    String name = scanner.nextLine();
    return name;
  }

  /** Test Scanner **/
  public static void justTry(){
    System.out.print("Masukan Nama Kamu: ");
    String name = String.valueOf(input());
    System.out.println("Halo, " + name);
    System.out.print("Masukan semester: ");
    Integer thisSemester = Integer.valueOf(input());
    System.out.println("Hebat, saat ini kamu sudah semester " + thisSemester);
    System.out.print("Kamu punya berapa impian: ");
    Integer numberOfDream = Integer.valueOf(input());
    for (Integer i = 0; i < numberOfDream; i++){
      if (i < numberOfDream) {
        System.out.print("Masukan impian ke " + ( i + 1)  + ": ");
        String yourdream = String.valueOf(input());
        addTodoList(yourdream);
      }
    }
    showTodoList();
    System.out.println("===Semangat!===");


  }

}