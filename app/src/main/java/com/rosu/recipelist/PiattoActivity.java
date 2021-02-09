package com.rosu.recipelist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class PiattoActivity extends AppCompatActivity {

    Button btnCommenta;
    String piatto;
    DatabaseReference db;
    TextView txtCommenti;

    boolean nomeInserito=false;
    boolean commentoInserito=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piatto);

        TextView txtTitle=findViewById(R.id.txtTitle);
        txtCommenti=findViewById(R.id.txtCommenti);
        ImageView imgPiatto=findViewById(R.id.imgPiatto);
        EditText txtNomeC=findViewById(R.id.txtNomeC);
        EditText txtCommento=findViewById(R.id.txtCommento);
        TextView txtRicetta=findViewById(R.id.txtRicetta);
        btnCommenta=findViewById(R.id.btnCommenta);
        btnCommenta.setEnabled(false);


        Intent intent=getIntent();
        piatto=intent.getStringExtra("piatto");
        db= FirebaseDatabase.getInstance().getReference("commenti").child(piatto);


        if(piatto.equals("carbonara"))
        {
            txtTitle.setText("SPAGHETTI ALLA CARBONARA");
            imgPiatto.setImageResource(R.drawable.carbonara);
            txtRicetta.setText(Ricetta.carbonaraR);
        }else if(piatto.equals("baba"))
        {
            txtTitle.setText("BABA' AL RUM");
            imgPiatto.setImageResource(R.drawable.baba);
            txtRicetta.setText(Ricetta.baba);
        }else if(piatto.equals("polpette"))
        {
            txtTitle.setText("POLPETTE AL SUGO");
            imgPiatto.setImageResource(R.drawable.polpette);
            txtRicetta.setText(Ricetta.polpette);
        }else if(piatto.equals("frittelle"))
        {
            txtTitle.setText("FRITTELLE DOLCI");
            imgPiatto.setImageResource(R.drawable.frittelledolci);
            txtRicetta.setText(Ricetta.fritelle);
        }else if(piatto.equals("lasagne"))
        {
            txtTitle.setText("LASAGNE AL FORNO");
            imgPiatto.setImageResource(R.drawable.lasagne);
            txtRicetta.setText(Ricetta.lasagne);
        }else if(piatto.equals("strudel"))
        {
            txtTitle.setText("STRUDEL DI MELE");
            imgPiatto.setImageResource(R.drawable.strudel);
            txtRicetta.setText(Ricetta.strudel);
        }else if(piatto.equals("salmone"))
        {
            txtTitle.setText("SALMONE AL FORNO");
            imgPiatto.setImageResource(R.drawable.salmone);
            txtRicetta.setText(Ricetta.salmone);
        }else if(piatto.equals("tiramisu"))
        {
            txtTitle.setText("TIRAMISU");
            imgPiatto.setImageResource(R.drawable.tiramisu);
            txtRicetta.setText(Ricetta.tiramisu);
        }else if(piatto.equals("risotto"))
        {
            txtTitle.setText("RISOTTO AI FUNGHI PORCINI");
            imgPiatto.setImageResource(R.drawable.risottofunghi);
            txtRicetta.setText(Ricetta.risotto);
        }else if(piatto.equals("crostata"))
        {
            txtTitle.setText("CROSTATA AI FRUTTI DI BOSCO");
            imgPiatto.setImageResource(R.drawable.crostataa);
            txtRicetta.setText(Ricetta.crostata);
        }

        leggiDB();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        txtNomeC.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!txtNomeC.getText().toString().equals(""))
                {
                    nomeInserito=true;
                }
                if(nomeInserito && commentoInserito)
                {
                    btnCommenta.setEnabled(true);
                }
            }
        });

        txtCommento.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!txtNomeC.getText().toString().equals(""))
                {
                    commentoInserito=true;
                }
                if(nomeInserito && commentoInserito)
                {
                    btnCommenta.setEnabled(true);
                }
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        btnCommenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Commento commento=new Commento(txtNomeC.getText().toString(),txtCommento.getText().toString(),piatto);
                db.child(commento.getNome()).setValue(commento);

                txtNomeC.setText("");
                txtCommento.setText("");
                txtCommenti.setText("Commenti");
                btnCommenta.setEnabled(false);
                nomeInserito=false;
                commentoInserito=false;
            }
        });

    }

    private  void leggiDB()
    {
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot c : snapshot.getChildren())
                {
                    if(c.child("idPiatto").getValue().toString().equals(piatto))
                    {
                        txtCommenti.setText(txtCommenti.getText()+"\n --> Nome: "+c.child("nome").getValue().toString()+
                                "\n      Commento: "+c.child("commento").getValue().toString());
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }
}

class  Ricetta
{
    static  String carbonaraR= "\n" +
            "INGREDIENTI(PER DUE PERSONE):\n" +
            "-guanciale 180 g di guanciale a fette spesse\n" +
            "-spaghetti 200 g di spaghetti\n" +
            "-tuorlo 3 tuorli grossi\n" +
            "-sale e pepe q.b. sale e pepe\n" +
            "-olio q.b. olio extra vergine di oliva\n" +
            "-pecorino q.b. pecorino grattugiato\n" +
            "\n" +
            "Per prima cosa buttiamo gli spaghetti in acqua bollente salata e li facciamo cuocere." +
            "Tagliamo a tocchetti le fette di guanciale, senza eliminare il grasso.In una padella soffriggiamo i tocchetti di guanciale fino a farlo diventare leggermente croccante e metterlo da parte. " +
            "Sbattiamo i tuorli in una boule, aggiungiamo abbondante pepe, 2 o 3 cucchiai di pecorino grattugiato ed un pizzico di sale. Scoliamo la pasta , la versiamo nella boule rigirando il tutto continuamente e aggiungendo il guanciale con il suo grasso di cottura." +
            "Infine grattugiamo abbondante pecorino.";

    static String baba= "\n" +
            "PER I BABÀ"+"\n" +
            "-125 g di farina" +"\n" +
            "-50 g di burro" +"\n" +
            "-2 uova intere (grandi) e 1 tuorlo" +"\n" +
            "-15 g di latte,zucchero e lievito di birra" +"\n" +
            "PER LO SCIROPPO" +"\n" +
            "-500 g di acqua,250 g di zucchero e rum" +"\n"
            +"\n" +
            "Pesare il burro e lasciarlo ammorbidire a temperatura ambiente. Mettere nella planetaria la farina e il lievito, la metà delle uova, montare la foglia e impastare a velocità bassa per 30 secondi, quindi aumentare la velocità aggiungere il resto delle uova tranne una o due, impastare a velocità alta per circa 5 minuti. Far lievitare in forno tiepido finché non raggungono il bordo, quindi infornare a 180 gradi." +"\n" +
            "Quando i babà sono pronti, farli inzuppare per 3-4 minuti nella bagna, metterli a raffreddare su una griglia con sotto un piatto per recuperare la bagna.";
    static String polpette="\n" +
            "INGREDIENTI "+"\n" +
            "-500 g macinato misto e 400 g di passata di pomodoro "+"\n" +
            "-1 uovo e 1 cucchiaio parmigiano" +"\n" +
            "-60 ml latte e 50 ml di vino +\n" +
            "-80 g pangrattato circa "+"\n" +
            "-sale q.b. e o.e.o "+"\n" +
            "-1/2 cipolla e 1/2 carota" +"\n"
            +"\n" +
            "In una ciotola versiamo la carne macinata, aggiungiamo un uovo, il parmigiano, il latte, il prezzemolo tritato e il sale."+"\n" +
            "Impastiamo bene con una forchetta fino a ottenere un impasto omogeneo. "+"\n" +
            " Quindi aggiungiamo le polpette una per una e lasciamo rosolare qualche minuto."+"\n" +
            "Mescoliamo delicatamente in modo che siano belle dorate da tutti i lati. Aggiungiamo mezzo bicchiere scarso di vino e copriamo con il coperchio.Lasciamo cuocere. \"";
    static String fritelle="INGREDIENTI" +
            "\n" +
            "-350 g farina 00 e 60 g zucchero"+"\n"+
            "-1 uovo" +"\n" +
            "-120 ml latte" +"\n" +
            "-2 cucchiai olio di semi di girasole" +"\n" +
            "-1 bustina lievito in polvere per dolci" +"\n" +
            "-Scorza di limone (grattugiata)" +"\n"
             +"\n" +
            "Incominciare con il setacciare la farina e il lievito, versarli nella ciotola della planetaria, unire lo zucchero e mescolarle. Scaldare leggermente il latte per intiepidirlo e versarlo sulla farina. Unire l’uovo sgusciato, la scorza grattugiata di un limone, e l’olio. Far lavorare la macchina fino ad ottenere un composto liscio ed omogeneo e che non si attacchi alle mani e, in caso contrario, aggiungere un poco di farina." +"\n" +
            " Man mano che lavorate una pallina, le altre copritele con la pellicola perchè, asciugandosi, la pasta si secca in superficie. ";
    static String lasagne="PER IL RAGÙ\n" +
            "-150 g di pancetta tesa e 150 g di macinato misto\n" +
            "-1/2 bicchiere di vino bianco secco\n" +
            "-300 g di passata di pomodoro\n" +
            "-1 sedano,1 carota,1 cipolla\n" +
            "-sale grosso e pepe\n" +
            "\n" +
            "PER BESCIAMELLA\n" +
            "-1 dose e mezzo di besciamella\n" +
            "\n" +
            "Scaldate l’olio e il burro in una casseruola dal fondo pesante sul fuoco, aggiungete la cipolla tritata e fatela rosolare dolcemente, quindi unite il sedano e la carota tritati e rosolate anche questi.Trasferite nel frattempo gli spinaci in una casseruola con un dito di acqua, salateli e cuoceteli, leggermente coperti, fino a quando saranno diventati teneri.Preriscaldate il forno a 180°, modalità ventilata. Prima di infornare, porzionate con un coltello le lasagne. Fatele cuocere per circa 45 minuti, o comunque fino a quando esse si saranno gonfiate e saranno ben calde anche all’interno.";
    static String strudel="INGREDIENTI PER L'IMPASTO\n" +
            "-Farina 00 130 g \n" +
            "-Acqua 30 ml \n" +
            "-Olio di semi (1 cucchiaio) 9 g \n" +
            "-Uova (circa 1) 54 g \n" +
            "-Sale 1 pizzico \n" +
            "\n" +
            "PER IL RIPIENO\n" +
            "-Mele Golden 750 g \n" +
            "-Zucchero 60 g e pangrattato\n" +
            "-Burro e uvetta 50 g \n" +
            "-Cannella in polvere 1 cucchiaino \n" +
            "\n" +
            "Per la preparazione dello strudel di mele, iniziate dall'impasto: in una ciotola versate la farina setacciata e il sale;poi aggiungete l'uovo,l'acqua e iniziate ad impastare con le mani. Unite poi l'olioe lavorate ancora il composto fino ad ottenere un impasto omogeneo 6. Se dovesse risultare troppo appiccicoso potete aggiungere ancora 10-20 g di farina al massimo.";
    static  String  salmone="INGREDIENTI\n" +
            "\n" +
            "-Tranci di salmone (4 pezzi) 660 g \n" +
            "-Patate 170 g \n" +
            "-Scorza di limone 1 \n" +
            "-Succo di limone e vino bianco secco 25 g \n" +
            "-Olio extravergine d'oliva 50 g \n" +
            "-Prezzemolo da tritare 1 cucchiaio \n" +
            "-Sale fino e pepe q.b. \n" +
            "\n" +
            "Per preparare il salmone al forno, per prima cosa eliminate le lische del pesce con una pinzetta e controllate che non vi siano spine rimaste facendo scorrere un polpastrello sulla polpa. Rimuovete la spina dorsale con un coltello, poi arrotolate un’estremità su se stessa e avvolgete l’altra estremità intorno al trancio in modo da ottenere un medaglione.Quando i medaglioni saranno pronti 16, cuocete in forno statico preriscaldato a 180° per circa 20 minuti, dopodiché azionate il grill a 240° e proseguite la cottura per altri 3-4 minuti.";
    static String tiramisu="INGREDIENTI\n" +
            "\n" +
            "-Savoiardi 300 g \n" +
            "-Uova freschissime (circa 4 medie) 220 g \n" +
            "-Mascarpone 500 g \n" +
            "-Zucchero 100 g \n" +
            "-Caffè della moka già pronto 300 g \n" +
            "\n" +
            "Per preparare il tiramisù cominciate dalle uova (freschissime): quindi separate accuratamente gli albumi dai tuorli.Man mano distribuite i savoiardi imbevuti sulla crema, tutti in un verso, così da ottenere un primo strato sul quale andrete a distribuire una parte della crema al mascarpone.";
    static  String risotto="INGREDIENTI\n" +
            "\n" +
            "-Riso Carnaroli 240 g \n" +
            "-Funghi chiodini e champignon 200 g \n" +
            "-Cipolle 1/2 \n" +
            "-Parmigiano Reggiano DOP 60 g \n" +
            "-Sale fino e o.e.o q.b. \n" +
            "-Vino bianco 50 g \n" +
            "-Acqua 1 l \n" +
            "\n" +
            "Per preparare il risotto ai funghi iniziate dalla pulizia degli Champignon. Eliminate la parte finale del gambo , poi spellateli utilizzando un coltellino.Prendete un tegame capiente che servirà per la cottura del risotto, aggiungete metà della dose di burro (40 g) e lasciatelo fondere dolcemente. Unite poi la cipolla 10 e lasciatela imbiondire prima di aggiungere i funghi.\n" +
            "    ";
    static String crostata="INGREDIENTI\n" +
            "\n" +
            "-Burro 100 g \n" +
            "-Uova 2 tuorli\n" +
            "-Farina 200 g\n" +
            "-Limone 1 \n" +
            "-Zucchero a velo 80 g \n" +
            "-Fragoline 130 g\n" +
            "-More,ribes,mirtilli e lamponi 130 g \n" +
            "\n" +
            "Preparate la pasta frolla frullando farina e burro in un mixer, versando il composto su un piano da lavoro e aggiungendovi zucchero a velo e scorza di limone grattugiata.Togliete la pasta frolla dal frigo e stendetela sul piano con un mattarello, fino a farle raggiungere lo spessore di 1 cm. Stendetela su uno stampo per torte infarinato e imburrato e bucherellate la superficie.";
}