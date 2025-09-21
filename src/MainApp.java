import java.util.Scanner;

public class MainApp{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
SQLDatabase db=new SQLDatabase();
db.connect();

while(true){
System.out.println("\n=== Event Management System ===");
System.out.println("1.Admin - Add Event");
System.out.println("2.View Events");
System.out.println("3.Register Participant");
System.out.println("4.Register For Event");
System.out.println("5.View Participants in Event");
System.out.println("6.Exit");
System.out.print("Choice:");

int ch=sc.nextInt();
sc.nextLine();

if(ch==1){
System.out.print("Enter admin code:");
String code=sc.nextLine();
if(code.equals("ADMIN123")){
System.out.print("Event name:");
String en=sc.nextLine();
System.out.print("Event date:");
String dt=sc.nextLine();
db.insertEvent(en,dt);
}else{
System.out.println("Wrong admin code");
}
}
else if(ch==2){
db.viewEvents();
}
else if(ch==3){
System.out.print("Participant name:");
String pn=sc.nextLine();
System.out.print("Email:");
String em=sc.nextLine();
db.insertParticipant(pn,em);
}
else if(ch==4){
db.viewEvents();
System.out.print("Event id:");
int eid=sc.nextInt();
System.out.print("Participant id:");
int pid=sc.nextInt();
db.registerForEvent(eid,pid);
}
else if(ch==5){
System.out.print("Event id:");
int ev=sc.nextInt();
db.viewParticipants(ev);
}
else if(ch==6){
System.out.println("Bye");
break;
}
else{
System.out.println("Invalid choice");
}
}
sc.close();
}
}
