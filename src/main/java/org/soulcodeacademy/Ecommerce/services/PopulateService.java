package org.soulcodeacademy.Ecommerce.services;
import org.soulcodeacademy.Ecommerce.domain.*;
import org.soulcodeacademy.Ecommerce.domain.enums.Carrinho;
import org.soulcodeacademy.Ecommerce.domain.enums.Tipo;
import org.soulcodeacademy.Ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class PopulateService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private EmpreendedorRepository empreendedorRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private FotosRepository fotosRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private PedidoRepository pedidoRepository;


    @PostConstruct
    public void Populate(){

        Endereco ed1 = new Endereco("06416-150","Cafelandia Brasil",102,"Barueri","Barueri","Sp","barueri");
        Endereco ed2 = new Endereco("03316-170","Passargada",200,"centro","RJ","RJ","Av.urubus");
        Endereco ed3 = new Endereco("03510-200","Trilhas do paraíso",105,"centro","Natal","RN","Morro do Careca");
        Endereco ed4 = new Endereco("02113-300","Labirinto do José",205,"pirapora","São Bento","RN","Av.Roberto Freire");
        Endereco ed5 = new Endereco("01230-100","Canhoto torto",115,"centro","São Paulo","Sp","Av.Paulsita");
        Endereco ed6 = new Endereco("01010-101","Rua dos montes",310,"centro","Paraíba","PB","Lago Seco");
        Endereco ed7 = new Endereco("03896-150","Fontes Calientes",400,"centro","SC","SC","Parque dos coiotes");
        Endereco ed8 = new Endereco("02456-789","Manoel Assis",350,"centro","Fortaleza","CE","Praça do Cortez");
        Endereco ed9 = new Endereco("03985-100","Prefeito Jacques",285,"centro","Tianguá","CE","Praça Matriz");
        Endereco ed10 = new Endereco("03986-500","Altos claros",810,"centro","Viçosa","CE","Igreja do Céu");

        this.enderecoRepository.saveAll(List.of(ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9,ed10));



        Administrador adm1 = new Administrador("Kelly","Barbosa","kellybarbosa@gmail.com","86717831545", encoder.encode("50000"),"965631245","25/10/1990",ed1);
        Administrador adm2 = new Administrador("Rafael","camilo","rafaelcamilo@gmail.com","16258560911", encoder.encode("10101"), "965789634","25/10/1990",ed2);
        Administrador adm3 = new Administrador("Miliana","Rocha","miliana@gmail.com","99138573253", encoder.encode("10102"), "965789645","25/10/1990",ed3);
        Administrador adm4 = new Administrador("Joel","Pitter","joel@gmail.com","45650671885", encoder.encode("10103"), "965002264","25/10/1990",ed4);
        Administrador adm5 = new Administrador("Marcos","Silva","marcos@gmail.com","06519589462", encoder.encode("10104"), "965789654","25/10/1990",ed5);
        Administrador adm6 = new Administrador("José","carlos","josecarlos@gmail.com","41680275704", encoder.encode("10105"), "965112234","25/10/1990",ed6);
        Administrador adm7 = new Administrador("Gabriel","Silva","gabriel@gmail.com","11411525760", encoder.encode("10106"), "967896457","25/10/1990",ed7);
        Administrador adm8 = new Administrador("William","Gomes","william@gmail.com","57844547146", encoder.encode("10107"), "977889995","25/10/1990",ed8);
        Administrador adm9 = new Administrador("Jorge","Silva","jorge@gmail.com","06714604041", encoder.encode("10108"), "966987845","25/10/1990",ed9);
        Administrador adm10 = new Administrador("Mariana","Duarte","mariana@gmail.com","44418238867", encoder.encode("10109"), "967896545","25/10/1990",ed10);

        adm1.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2FCapturar.PNG?alt=media&token=ec698805-f9f2-433b-977e-530fff549025");
        adm2.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2FRafael%20Camilo.jpg?alt=media&token=06a57480-ed02-404d-9a1d-e6a4dd9fb028");
        adm3.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2FCapturar1.PNG?alt=media&token=9cc56281-122b-4292-9e59-c5b482e9060e");
        adm4.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Fpngtree-side-blue-suit-figures-png-image_3220923.jpg?alt=media&token=b5556384-d2e3-4a9f-8fea-9b9a881e779c");
        adm5.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2F39763954dde9501296570093d9e97a3b.jpg?alt=media&token=bf8e11b7-70d4-4a89-8bc4-8b31105ffbda");
        adm6.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Fimages%20(1).jfif?alt=media&token=6662ad2f-fd5c-4b72-b948-1c2db23cbb1f");
        adm7.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Fpngtree-hand-drawn-cartoon-puppy-and-owner-free-illustration-image_1371652.jpg?alt=media&token=ff5a6eae-400b-4f31-a65f-b81e4bbafacb");
        adm8.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Fpngtree-cartoon-gray-haired-old-man-annoying-taking-medicine-png-image_2604011.jpg?alt=media&token=4c041c8d-e37a-4e8f-9dfb-fc337f216bc3");
        adm9.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Fpngtree-man-singing-original-hand-drawn-cartoon-png-image_2602253.jpg?alt=media&token=563cad24-8800-402a-8b1d-8b4fec1b1c28");
        adm10.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2F10466013.jpg?alt=media&token=19d324ff-eb5b-41a9-97a6-aad12afcaa0e");

        this.administradorRepository.saveAll(List.of(adm1,adm2,adm3,adm4,adm5,adm6,adm7,adm8,adm9,adm10));



        Empreendedor emp1 = new Empreendedor("Aline","Silva","aline@gmail.com","52062846703", encoder.encode("101010"), "996547823","03/01/1980",ed1,"Reino Tech","Hardware");
        Empreendedor emp2 = new Empreendedor("Rodrigo","Alves","rodrigo@gmail.com","12310590363", encoder.encode("101020"), "996547823","31/10/1985",ed2,"TechTudo","Software");
        Empreendedor emp3 = new Empreendedor("Ariana","Atazanio","ariana@gmail.com","89766821496", encoder.encode("101030"), "996547823","10/10/1987",ed3,"TechBom","Hardware");
        Empreendedor emp4 = new Empreendedor("Tânia","Damasceno","tania@gmail.com","98386696362", encoder.encode("101040"), "996547823","05/05/2000",ed4,"MegaTech","Hardware");
        Empreendedor emp5 = new Empreendedor("Pedro","Silva","pedro@gmail.com","45219284630", encoder.encode("101050"), "996547823","02/11/1979",ed5,"Tech Magic","Software");
        Empreendedor emp6 = new Empreendedor("Leonardo","Pires","leonardo@gmail.com","33326043686", encoder.encode("101060"), "996547823","20/10/1981",ed6,"TechShow","Hardware");
        Empreendedor emp7 = new Empreendedor("Rafael","Camilo","rafael@gmail.com","14626316069", encoder.encode("101070"), "996547823","10/10/1980",ed7,"TechTop","Hardware");
        Empreendedor emp8 = new Empreendedor("Wesley","Ribeiro","wesley@gmail.com","77393193418", encoder.encode("101080"), "996547823","25/12/1990",ed8,"NewTech","Software");
        Empreendedor emp9 = new Empreendedor("Maria","Cunha","maria@gmail.com","06283525067", encoder.encode("101090"), "996547823","01/10/1980",ed9,"Corporation Tech","Hardware");
        Empreendedor emp10 = new Empreendedor("José","Silva","jose@gmail.com","92548321622", encoder.encode("101091"), "996547823","02/10/1982",ed10,"Center Tech","Hardware");

        emp2.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2FCapturar6.PNG?alt=media&token=f4b3ca7e-9ddb-451d-945c-08ee491556c4");
        emp3.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2FCapturar678.PNG?alt=media&token=7be62348-c10a-439d-8a04-edfd578aed9a");
        emp4.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2FCapturar9.PNG?alt=media&token=59c155c9-0aa8-4c23-9521-9f769e3eae9f");
        emp5.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Fimages%20(4).jfif?alt=media&token=e4aaea82-19b7-4575-af0f-fd84fccf1898");
        emp6.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2FCapturar00.PNG?alt=media&token=df21accc-04e1-4e55-90c3-5be90ff7d97b");
        emp7.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2FRafael%20Camilo.jpg?alt=media&token=06a57480-ed02-404d-9a1d-e6a4dd9fb028");
        emp8.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2FCapturar4.PNG?alt=media&token=5e4b0275-8083-43c3-a4eb-994238ef70d6");
        emp9.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2F%C3%ADcone-dos-desenhos-animados-da-mulher-de-neg%C3%B3cios-85311433.jpg?alt=media&token=d14c20d6-98c7-43bc-9ea1-6280b28c96af");
        emp10.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Fpng-clipart-man-holding-calculator-doing-ok-hand-sign-illustration-corporate-tax-accountant-tax-return-accounting-cartoon-character-company-hand.png?alt=media&token=86ef9322-e0b9-4011-bfc5-317f517076ae");
        emp1.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Freino%20tech.jfif?alt=media&token=5632397d-f560-4904-baf0-00b66bfb3208");
        emp1.setDataAbertura(LocalDate.of(2023,04,10));
        emp1.setMesDeCadastroUsuario(Month.APRIL);
        emp2.setDataAbertura(LocalDate.of(2023,04,11));
        emp2.setMesDeCadastroUsuario(Month.APRIL);
        emp3.setDataAbertura(LocalDate.of(2023,04,12));
        emp3.setMesDeCadastroUsuario(Month.APRIL);

        emp4.setDataAbertura(LocalDate.of(2023,02,25));
        emp4.setMesDeCadastroUsuario(Month.FEBRUARY);
        emp5.setDataAbertura(LocalDate.of(2023,02,11));
        emp5.setMesDeCadastroUsuario(Month.FEBRUARY);
        emp4.setDataAbertura(LocalDate.of(2023,02,10));
        emp4.setMesDeCadastroUsuario(Month.FEBRUARY);

        emp5.setDataAbertura(LocalDate.of(2023,03,30));
        emp5.setMesDeCadastroUsuario(Month.MARCH);
        emp6.setDataAbertura(LocalDate.of(2023,03,21));
        emp6.setMesDeCadastroUsuario(Month.MARCH);
        emp7.setDataAbertura(LocalDate.of(2023,03,13));
        emp7.setMesDeCadastroUsuario(Month.MARCH);
        emp8.setDataAbertura(LocalDate.of(2023,02,01));
        emp8.setMesDeCadastroUsuario(Month.FEBRUARY);
        emp9.setDataAbertura(LocalDate.of(2022, 9, 19));
        emp9.setMesDeCadastroUsuario(Month.SEPTEMBER);
        emp10.setDataAbertura(LocalDate.of(2022, 9, 20));
        emp1.setMesDeCadastroUsuario(Month.SEPTEMBER);


        emp1.setFoto("");

        emp1.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2FCaptura3r.PNG?alt=media&token=81a1e1ee-0bbc-4600-b3be-9a24ebfeabca");


        this.empreendedorRepository.saveAll(List.of(emp1,emp2,emp3,emp4,emp5,emp6,emp7,emp8,emp9,emp10));


        Cliente cl1 = new Cliente("moises","silva","moises@hotmail.com","42118821638", encoder.encode("12345"), "964789654","21/11/1990",ed1);
        Cliente cl2 = new Cliente("marcos","silva","marcos@hotmail.com","18343547497", encoder.encode("23456"), "478965412","05/10/1980",ed2);
        Cliente cl3 = new Cliente("joao","pereira","joao@hotmail.com","29109728368",encoder.encode("78910"),"477889966","01/11/1975",ed3);
        Cliente cl4 = new Cliente("lucas","sousa","lucas@hotmail.com","14417320985",encoder.encode("101112"),"422556633","05/02/11987",ed4);
        Cliente cl5 = new Cliente("mateus","carlito","mateus@hotmail.com","44804426183",encoder.encode("131415"),"477889966","02/03/1982",ed5);
        Cliente cl6 = new Cliente("samuel","lima","samuel@hotmail.com","77369503690",encoder.encode("161718"),"466889988","10/01/1978",ed6);
        Cliente cl7 = new Cliente("carlos","gomes","carlos@hotmail.com","25222667308",encoder.encode("192021"),"789966557","20/12/1994",ed7);
        Cliente cl8 = new Cliente("antonio","silva","antonio@hotmail.com","25864748803", encoder.encode("222324"), "789655442","06/11/1986",ed8);
        Cliente cl9 = new Cliente("sergio","santana","sergio@hotmail.com","58621637430",encoder.encode("252627"),"457569874","08/08/1997",ed9);
        Cliente cl10 = new Cliente("jordana","silva","jordana@hotmail.com","24553236176", encoder.encode("282930"), "778899651","01/10/2000",ed10);

        cl1.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Fman-farmer-holding-shovel-agricultural-cartoon-character-illustrations-free-png.webp?alt=media&token=6967e635-4067-48fa-b611-b65b7abcd38b");
        cl2.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Fpng-transparent-graphy-computer-icons-user-3d-character-icon-material-cartoon-character-camera-icon-phone-icon.png?alt=media&token=f5db33b0-c5ba-45fc-99f4-b75aa180e5e7");
        cl3.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Fimages%20(2).png?alt=media&token=a6bb1a22-a3b1-40bf-be7f-2a863e070718");
        cl4.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2F96t58PIC58PIC24bc3fAda4fd_PIC2018.png_860.png?alt=media&token=3111b871-e234-4885-9d55-b47f25c3e665");
        cl5.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2F10466013.jpg?alt=media&token=19d324ff-eb5b-41a9-97a6-aad12afcaa0e");
        cl6.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2F39763954dde9501296570093d9e97a3b.jpg?alt=media&token=bf8e11b7-70d4-4a89-8bc4-8b31105ffbda");
        cl7.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Fpng-clipart-man-holding-calculator-doing-ok-hand-sign-illustration-corporate-tax-accountant-tax-return-accounting-cartoon-character-company-hand.png?alt=media&token=86ef9322-e0b9-4011-bfc5-317f517076ae");
        cl8.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Fpngtree-hand-drawn-cartoon-puppy-and-owner-free-illustration-image_1371652.jpg?alt=media&token=ff5a6eae-400b-4f31-a65f-b81e4bbafacb");
        cl9.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2F96t58PIC58PIC24bc3fAda4fd_PIC2018.png_860.png?alt=media&token=3111b871-e234-4885-9d55-b47f25c3e665");
        cl10.setFoto("https://firebasestorage.googleapis.com/v0/b/e-commerce-91ed5.appspot.com/o/fotosDePerfil%2Fpng-transparent-woman-cartoon-businessperson-drawing-woman-people-public-relations-business.png?alt=media&token=50e3f3c0-3678-4efc-b6d0-f0abb440d3a5");

        cl1.setDataAbertura(LocalDate.of(2022, 01, 10));
        cl1.setMesDeCadastroUsuario(Month.JANUARY);
        cl2.setDataAbertura(LocalDate.of(2022, 05, 13));
        cl2.setMesDeCadastroUsuario(Month.JULY);
        cl3.setDataAbertura(LocalDate.of(2022, 10, 07));
        cl3.setMesDeCadastroUsuario(Month.OCTOBER);
        cl4.setDataAbertura(LocalDate.of(2022, 10, 25));
        cl4.setMesDeCadastroUsuario(Month.OCTOBER);
        cl5.setDataAbertura(LocalDate.of(2020, 07, 12));
        cl5.setMesDeCadastroUsuario(Month.JULY);
        cl6.setDataAbertura(LocalDate.of(2020, 01, 29));
        cl6.setMesDeCadastroUsuario(Month.JANUARY);
        cl7.setDataAbertura(LocalDate.of(2020, 10, 07));
        cl7.setMesDeCadastroUsuario(Month.OCTOBER);
        cl8.setDataAbertura(LocalDate.of(2023, 10, 25));
        cl8.setMesDeCadastroUsuario(Month.OCTOBER);
        cl9.setDataAbertura(LocalDate.of(2023, 07, 12));
        cl9.setMesDeCadastroUsuario(Month.JULY);
        cl10.setDataAbertura(LocalDate.of(2023, 01, 29));
        cl10.setMesDeCadastroUsuario(Month.JANUARY);


        this.clienteRepository.saveAll(List.of(cl1,cl2,cl3,cl4,cl5,cl6,cl7,cl8,cl9,cl10));

        Categoria c1 = new Categoria(Tipo.HARDWARE,"Fone De Ouvido");
        Categoria c5 = new Categoria(Tipo.HARDWARE,"Mouse ");
        Categoria c7 = new Categoria(Tipo.HARDWARE,"Teclado");
        Categoria c2 = new Categoria(Tipo.SOFTWARE,"Software Academicos");
        Categoria c3 = new Categoria(Tipo.SOFTWARE,"Sistemas Operacionais");

        this.categoriaRepository.saveAll(List.of(c1,c2,c3,c5,c7));

        Produto p1 = new Produto("Microsoft Office 2010","O Microsoft Office 2010 Professional Plus fornece acesso aos aplicativos Word, Excel, PowerPoint, Outlook, Publisher e Access. Para 01 (um) dispositivos. Software totalmente em português brasileiro (PT - BR). ",99.00, null,0.0,10,c2,"https://getproductkey.net/wp-content/uploads/2019/04/Microsoft-Office-2010-Free-Download-and-Activate.jpg",emp2);
        Produto p2 = new Produto("Microsoft Office 2010 licensa 12 meses","O Microsoft Office 2010 Professional Plus fornece acesso aos aplicativos Word, Excel, PowerPoint, Outlook, Publisher e Access. Para 01 (um) dispositivos. Software totalmente em português brasileiro (PT - BR). ",99.00, null,0.0,10,c2,"https://getproductkey.net/wp-content/uploads/2019/04/Microsoft-Office-2010-Free-Download-and-Activate.jpg",emp2);
        Produto p3 = new Produto("Office 365 personal licensa 12 meses","O Microsoft Office 365 é uma tecnologia revolucionária que permite aos usuários e às empresas de todos os tamanhos criar um escritório virtual na nuvem, que pode ser acessado de qualquer lugar a qualquer momento, além de permitir o armazenamento e a execução de aplicações hospedadas em datacenters da Microsoft.",249.00, null,20.0,200,c2,"https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcRl7Q6DVp931THsaOTXMN2vVNwVTOvuNjw2BNxyWc1OrxlzSbiSDhI_Ttm_OFjSLF4QrhFWY9Y_JOzO3aTHKvKsU51XS6DRx7v-zD2nyVjhk2m5TU6B1jNBNA&usqp=CAE",emp2);
        p3.setSuperProduto(true);
        Produto p4 = new Produto("Microsoft office 365 Family 6 usuários","O Microsoft Office 365 é uma tecnologia revolucionária que permite aos usuários e às empresas de todos os tamanhos criar um escritório virtual na nuvem, que pode ser acessado de qualquer lugar a qualquer momento, além de permitir o armazenamento e a execução de aplicações hospedadas em datacenters da Microsoft.",389.00, null,50.00,150,c2,"https://img.kalunga.com.br/fotosdeprodutos/670680d.jpg",emp5);
        Produto p5 = new Produto("Microsoft office 365 Business Standard","Aumente a produtividade da sua empresa com as ferramentas fundamentais do Office, alimentadas pela nuvem. O Microsoft 365 Business Standard simplifica como você trabalha, permitindo que as equipes colaborem entre si em tempo real, incluindo serviços e aplicativos business projetados para todos os seus dispositivos, incluindo faturamento, agendamento de compromissos e reservas.",999.00, null,50.00,100,c2,"https://img.kalunga.com.br/fotosdeprodutos/670752d.jpg ",emp5);
        p5.setSuperProduto(true);
        Produto p6 = new Produto("Microsoft office 365 Business Standard","Aumente a produtividade da sua empresa com as ferramentas fundamentais do Office, alimentadas pela nuvem. O Microsoft 365 Business Standard simplifica como você trabalha, permitindo que as equipes colaborem entre si em tempo real, incluindo serviços e aplicativos business projetados para todos os seus dispositivos, incluindo faturamento, agendamento de compromissos e reservas.",1049.00, null,0.0,100,c2,"https://img.kalunga.com.br/fotosdeprodutos/670752d.jpg ",emp8);
        Produto p7 = new Produto("Windows 11 Home","Com o novo Windows 11 você tem acesso à um mundo de possibilidades, acesse seus aplicativos com mais facilidade com um layout mais intuitivo e eficiente. Se conecte com o que realmente importa para você, com layouts mais dinâmicos e widgets personalizáveis.",990.00, null,0.0,130,c3,"https://img.kalunga.com.br/fotosdeprodutos/670737d.jpg",emp8);
        Produto p8 = new Produto("Windows 11 Pro","Com o novo Windows 11 você tem acesso à um mundo de possibilidades, acesse seus aplicativos com mais facilidade com um layout mais intuitivo e eficiente. Se conecte com o que realmente importa para você, com layouts mais dinâmicos e widgets personalizáveis.",1490.00, null,110.0,120,c3,"https://img.kalunga.com.br/fotosdeprodutos/670739d.jpg",emp8);
        p8.setSuperProduto(true);
        Produto p9 = new Produto("Apple AirPods Max Over The Ear","Bluetooth, Cancelamento de ruído, Com microfone, Som surround, Com estojo recarregador, Supra-auricular, Siri. Das almofadas ao arco, os AirPods Max foram pensados para proporcionar um ajuste perfeito, criando uma vedação acústica impecável que leva em consideração diferentes formatos de cabeça. Você vai se sentir dentro do som. Os AirPods Max combinam áudio de alta fidelidade e cancelamento de ruído líder do setor para oferecer uma experiência sonora sem igual. Cada peça do driver exclusivo contribui para uma distorção ultrabaixa em toda a faixa audível. Sejam graves ricos e profundos, médios precisos ou agudos límpidos, você ouve cada nota com um novo nível de clareza",6590.00, null,500.00,32,c1,"https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcR9bIFgggYsZna3b0RheOygclJChwpeevyiZy1IshtojGgb_S2wdoG4wJKhI-KnUkwCI53Am8JeweG-2WhBQVNvOZOBJ2kgvHTKclQgPUMYe-b5tRfkhZVS",emp6);
        Produto p10 = new Produto("Apple AirPods 3° Geração","A terceira geração dos AirPods que já são famosos pela technologia e qualidade de som.",1899.00, null,100.00,80,c1,"https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MME73?wid=572&hei=572&fmt=jpeg&qlt=95&.v=1632861342000",emp6);
        Produto p11 = new Produto("Fone de ouvido JBLT510BT","Leve, confortável e com design dobrável. Reproduza som de alta qualidade sem aquela bagunça dos fios com transmissão por Bluetooth 5.0. Até 40 horas de bateria e carregamento rápido: 5 minutos = 2 horas",250.00, null,10.00,150,c1,"https://m.media-amazon.com/images/I/51l93XwI2AL._AC_SX679_.jpg",emp1);
        Produto p12 = new Produto("Fone de ouvido Beats Studio3 Wireless","O fone de ouvido Beats Studio3 Wireless oferece uma experiência sonora de alta qualidade com o Pure ANC (Puro cancelamento ativo de ruído). ",2990.00, null,100.00,60,c1,"https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MXJA2?wid=572&hei=572&fmt=jpeg&qlt=95&.v=1580420177108",emp1);
        p3.setSuperProduto(true);
        Produto p13 = new Produto("Fone de ouvidos Redmi AirDots","Descrição do produto. Em busca de uma concorrente à altura, a Xiaomi começou a competir contra si mesma com seus Airdots. Desta vez com o Redmi Airdots, a Xiaomi estabelece um novo nível de qualidade e preço para fones de ouvido Bluetooth, proporcionando som de muita qualidade e excelente isolamento acústico.",199.00, null,0.0,2000,c1,"https://static.netshoes.com.br/produtos/fone-de-ouvido-bluetooth-xiaomi-redmi-airdots-/06/JYY-0009-006/JYY-0009-006_zoom1.jpg?ts=1642986461&",emp3);
        Produto p14 = new Produto("Mouse com fio Logitech M90","Simples de instalar e usar.a instalação é rápida e fácil. Não é preciso software.por ter fi o, basta conectá-lo a uma porta USBe começar a usá-lo",29.00, null,8.00,300,c5,"https://ae01.alicdn.com/kf/H30339762c407479f817fddacd3a9bf15m/Logitech-m90-original-com-fio-usb-1000dpi-mouse-tico-de-design-ergon-mico-para-laptop-pc.jpg_Q90.jpg_.webp",emp7);
        p14.setSuperProduto(true);
        Produto p15 = new Produto("Mouse sem fio Logitech M170","Alcance sem fio de 10 metros 12 meses de vida útil da pilha. Instalação fácil",59.00, null,0.0,40,c5,"https://m.media-amazon.com/images/I/51p1FOjU-lL._AC_SX679_.jpg",emp1);
        Produto p16 = new Produto("Mouse Gamer Logitech G203 6 botões","Sensor de 8.000 DPI - O sensor de nível avançado para jogos responde com precisão aos seus movimentos. Personalize as configurações para se adequar à sensibilidade que você gosta com o software de jogos Logitech G HUB e alterne facilmente até 5 configurações de DPI.",199.90, null,40.00,155,c5,"https://m.media-amazon.com/images/I/61UxfXTUyvL._AC_SX679_.jpg",emp3);
        Produto p17 = new Produto("Mouse Gamer Redragon M607","O GRIFFIN une o melhor do design e performance para Gamers, altere entre 4 velocidades de DPI com um simples toque de um botão, configure macros e funções Ingame nos botões laterais para acesso a comandos mais rápidos, com sensor PMW3212 o griffin é altamente recomendado para mobas e RPGs",100.00, null,2.90,78,c5,"https://mobile.comprasparaguai.com.br/media/fotos/produtos/thumbs/big/0830e5441ff62ac99b339079eb13571dc01aec36.jpg",emp3);
        Produto p18 = new Produto("Mouse Gamer HP M160","Dê o primeiro passo certeiro ao mundo gamer com o Mouse Gamer M160 da HP, design simples e direto com 3 botões, garante boa estabilidade durante o jogo",69.00, null,10.00,85,c5,"https://ph-test-11.slatic.net/p/984a50e270d7e6a1210457f57f345995.png",emp9);
        p18.setSuperProduto(true);
        Produto p19 = new Produto("Teclado Com Fio Logitech K120 ","O Logitech K120 oferece uma experiência de digitação confortável e silenciosa. O design fino e elegante mantém suas mãos em uma posição mais natural para que você possa digitar com maior conforto.",65.00, null,0.0,90,c7,"https://m.media-amazon.com/images/I/61ji72MgnEL._AC_SX679_.jpg",emp1);
        Produto p20 = new Produto("Teclado Gamer Redragon Lakshmi","Para os gamers que procuram deixar o máximo de espaço possível sobre a mesa, o Redragon Lakshmi vem no layout compacto 60% ABNT2.",210.00, null,10.00,50,c7,"https://m.media-amazon.com/images/I/61CPK7k3tEL._AC_SX679_.jpg",emp4);
        Produto p21 = new Produto("Teclado Gamer League Of Legends Logitech","Com design compacto TKL, ele conta com switches GX Brown tactile, LIGHTSYNC RGB programável, cabo micro-USB removível - para fácil conexão e transporte seguro, ajuste do ângulo em três etapas - com base de borracha para excelente estabilidade - e 12 teclas F macros programáveis. Parte de uma coleção que é mais do que apenas um setup para jogos. Trata-se de ferramentas consagradas: criadas como um passe de mágica, ajustadas pela ciência e aprovadas pelos campeões.",799.00, null,80.00,30,c7,"https://www.logitechstore.com.br/media/catalog/product/cache/1/image/634x545/9df78eab33525d08d6e5fb8d27136e95/t/e/teclado_logiitech.png",emp4);
        p3.setSuperProduto(true);
        Produto p22 = new Produto("Teclado sem fio Logitech K380","O teclado multi-dispositivo BluetoothR LogitechR K380 traz o conforto e a conveniencia da digitacao para seu desktop, smartphone, tablet e muito mais",210.00, null,10.00,100,c7,"https://m.media-amazon.com/images/I/61Vs0otp73L._AC_SX679_.jpg",emp10);
        Produto p23 = new Produto("Teclado Gamer Redragon Karura K502RGB","Teclado full size slim para os usuários que não podem ficar sem o teclado numérico em jogos ou durante uso diário, Layout ABNT2 feito especialmente para o mercado brasileiro, Apoio de pulso integrado para maior conforto até mesmo durante longos períodos de uso",199.00, null,20.00,33,c7,"https://m.media-amazon.com/images/I/61yU-vtXcBL._AC_SX679_.jpg",emp10);

        p1.setDataDeCadastro(LocalDate.of(2022,07,02));
        p1.setMesDeCadastro(Month.JULY);
        p2.setDataDeCadastro(LocalDate.of(2022,03,25));
        p2.setMesDeCadastro(Month.MARCH);
        p3.setDataDeCadastro(LocalDate.of(2022,07,02));
        p3.setMesDeCadastro(Month.JULY);
        p4.setDataDeCadastro(LocalDate.of(2023,07,02));
        p4.setMesDeCadastro(Month.JULY);

        p5.setDataDeCadastro(LocalDate.of(2023,07,02));
        p5.setMesDeCadastro(Month.JULY);
        p6.setDataDeCadastro(LocalDate.of(2023,03,02));
        p6.setMesDeCadastro(Month.MARCH);
        p7.setDataDeCadastro(LocalDate.of(2023,03,02));
        p7.setMesDeCadastro(Month.MARCH);
        p8.setDataDeCadastro(LocalDate.of(2023,02,02));
        p8.setMesDeCadastro(Month.FEBRUARY);

        p9.setDataDeCadastro(LocalDate.of(2023,03,02));
        p9.setMesDeCadastro(Month.MARCH);
        p10.setDataDeCadastro(LocalDate.of(2023,8,01));
        p10.setMesDeCadastro(Month.AUGUST);

        p11.setDataDeCadastro(LocalDate.of(2023,02,05));
        p1.setMesDeCadastro(Month.JULY);
        p12.setDataDeCadastro(LocalDate.of(2023,02,02));
        p1.setMesDeCadastro(Month.FEBRUARY);

        this.produtoRepository.saveAll(List.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23));


        Pedido pedido1 = new Pedido(150.00, cl2,  ed1);
        Pedido pedido3 = new Pedido(35.00, cl4,  ed2);
        Pedido pedido2 = new Pedido(35.00, cl3,  ed2);
        this.pedidoRepository.saveAll(List.of(pedido1,pedido2,pedido3));


        Fotos f1 = new Fotos("Rafael",p1);
        Fotos f2 = new Fotos("Peterson",p1);
        Fotos f3 = new Fotos("Gabriel",p1);

        this.fotosRepository.saveAll(List.of(f1,f2,f3));

        //mateus@hotmail.com
        //samuel@hotmail.com
        //moises@hotmail.com
        Item I1 = new Item(200,"moises@hotmail.com",200.10,p16);
        I1.setPedidoVinculado(pedido3);
        I1.setCarrinho(Carrinho.PROCESSANDO);
        Item I2 = new Item(200,"moises@hotmail.com",230.10,p1);
        I2.setPedidoVinculado(pedido2);
        I2.setCarrinho(Carrinho.PROCESSANDO);
        Item I3 = new Item(200,"moises@hotmail.com",100.10,p11);
        I3.setCarrinho(Carrinho.PROCESSANDO);
        I3.setPedidoVinculado(pedido1);
        Item I4 = new Item(200,"moises@hotmail.com",200.10,p8);
        I4.setPedidoVinculado(pedido2);
        Item I5 = new Item(200,"samuel@hotmail.com",20.10,p11);
        I5.setCarrinho(Carrinho.PROCESSANDO);
        I5.setPedidoVinculado(pedido1);
        Item I6 = new Item(200,"samuel@hotmail.com",700.10,p15);
        I4.setPedidoVinculado(pedido1);
        Item I7 = new Item(200,"samuel@hotmail.com",205.10,p10);
        I4.setPedidoVinculado(pedido3);
        Item I8 = new Item(200,"samuel@hotmail.com",600.10,p11);
        I4.setPedidoVinculado(pedido2);
        I8.setCarrinho(Carrinho.PROCESSANDO);
        Item I9 = new Item(200,"mateus@hotmail.com",670.10,p1);
        I4.setPedidoVinculado(pedido1);
        Item I10 = new Item(200,"mateus@hotmail.com",60.10,p2);
        I4.setPedidoVinculado(pedido3);
        Item I11 = new Item(200,"mateus@hotmail.com",690.10,p3);
        I4.setPedidoVinculado(pedido1);
        Item I12 = new Item(200,"mateus@hotmail.com",70.10,p11);
        I4.setPedidoVinculado(pedido3);
        I12.setCarrinho(Carrinho.PROCESSANDO);


        this.itemRepository.saveAll(List.of(I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12));

    }

}