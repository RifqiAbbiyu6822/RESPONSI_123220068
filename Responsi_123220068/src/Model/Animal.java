/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Lab Informatika
 */
class Animal {
    private int id;
    private String nama;
     private String kelas;
      private String jenisMakanan;
      
      public Animal(int id, String nama, String kelas, String jenisMakanan){
          this.id = id;
          this.nama = nama;
          this.kelas = kelas;
          this.jenisMakanan = jenisMakanan;
          
         
      }
      public int getId() {
          return id;
      }
      
      public String getNama(){
          return nama;
      }
       public String getKelas(){
          return kelas;
      }
       public String getJenisMakanan(){
          return jenisMakanan;
      }
    
    
}
