PGDMP     $                 	    x         	   dbplaybox    12.4    12.4 a    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16393 	   dbplaybox    DATABASE     �   CREATE DATABASE dbplaybox WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE dbplaybox;
                postgres    false            �            1255    16394    data_cadastro()    FUNCTION     +  CREATE FUNCTION public.data_cadastro() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
		INSERT INTO log_novo_cliente VALUES (NOW(),NEW.id, NEW.situacao, NEW.cpf, NEW.nomecompleto, NEW.datanascimento, NEW.genero, NEW.email, NEW.senha, NEW.celular);        
        RETURN NEW;
    END;
$$;
 &   DROP FUNCTION public.data_cadastro();
       public          postgres    false            �            1255    16395    log_clientes_alterados()    FUNCTION     6  CREATE FUNCTION public.log_clientes_alterados() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        INSERT INTO log_cliente_alterado VALUES (NOW(),OLD.id, OLD.situacao, OLD.cpf, OLD.nomecompleto, OLD.datanascimento, OLD.genero, OLD.email, OLD.senha, OLD.celular);
        RETURN OLD;
    END;
$$;
 /   DROP FUNCTION public.log_clientes_alterados();
       public          postgres    false            �            1255    16396    log_edicao_clientes()    FUNCTION     ,  CREATE FUNCTION public.log_edicao_clientes() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
    BEGIN
        INSERT INTO log_edicao_clientes VALUES (OLD.id, OLD.situacao, OLD.cpf, OLD.nomecompleto, OLD.datanascimento, OLD.genero, OLD.email, OLD.senha, OLD.celular);
        RETURN OLD;
    END;
$$;
 ,   DROP FUNCTION public.log_edicao_clientes();
       public          postgres    false            �            1259    24576 
   assinatura    TABLE     t   CREATE TABLE public.assinatura (
    id integer NOT NULL,
    nome character varying,
    preco double precision
);
    DROP TABLE public.assinatura;
       public         heap    postgres    false            �            1259    16397    camiseta    TABLE     �  CREATE TABLE public.camiseta (
    id integer NOT NULL,
    nome character varying NOT NULL,
    descricao character varying NOT NULL,
    sexo character varying NOT NULL,
    tamanho character varying NOT NULL,
    imagem character varying NOT NULL,
    situacao character varying NOT NULL,
    quantidade integer NOT NULL,
    preco double precision NOT NULL,
    CONSTRAINT camiseta_quantidade_check CHECK ((quantidade >= 0))
);
    DROP TABLE public.camiseta;
       public         heap    postgres    false            �            1259    16404    cartaocredito    TABLE     �   CREATE TABLE public.cartaocredito (
    id integer NOT NULL,
    numerocartao character varying,
    nomeimpresso character varying,
    validade character varying,
    codigo integer,
    bandeira character varying,
    clientefk integer
);
 !   DROP TABLE public.cartaocredito;
       public         heap    postgres    false            �            1259    16410    cliente    TABLE     �  CREATE TABLE public.cliente (
    id integer NOT NULL,
    situacao character varying NOT NULL,
    cpf character varying NOT NULL,
    nomecompleto character varying NOT NULL,
    datanascimento character varying NOT NULL,
    genero character varying NOT NULL,
    email character varying NOT NULL,
    senha character varying NOT NULL,
    celular character varying NOT NULL,
    assinatura character varying,
    cobranca character varying
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    16416    compra    TABLE       CREATE TABLE public.compra (
    id integer NOT NULL,
    datahora date NOT NULL,
    valor double precision NOT NULL,
    statusfk integer,
    clientefk integer,
    enderecoentregafk integer,
    metodopagamentofk integer,
    cartaocreditofk integer
);
    DROP TABLE public.compra;
       public         heap    postgres    false            �            1259    16419    endereco    TABLE     @  CREATE TABLE public.endereco (
    id integer NOT NULL,
    cep integer NOT NULL,
    rua character varying NOT NULL,
    numero integer NOT NULL,
    complemento character varying,
    bairro character varying NOT NULL,
    cidade character varying NOT NULL,
    uf character varying NOT NULL,
    clientefk integer
);
    DROP TABLE public.endereco;
       public         heap    postgres    false            �            1259    16425    games    TABLE     �  CREATE TABLE public.games (
    id integer NOT NULL,
    nome character varying NOT NULL,
    descricao character varying NOT NULL,
    plataforma character varying NOT NULL,
    imagem character varying NOT NULL,
    situacao character varying NOT NULL,
    quantidade integer NOT NULL,
    preco double precision NOT NULL,
    CONSTRAINT games_quantidade_check CHECK ((quantidade >= 0))
);
    DROP TABLE public.games;
       public         heap    postgres    false            �            1259    24589    id_assinatura    SEQUENCE     v   CREATE SEQUENCE public.id_assinatura
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.id_assinatura;
       public          postgres    false            �            1259    16432    id_camiseta    SEQUENCE     t   CREATE SEQUENCE public.id_camiseta
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.id_camiseta;
       public          postgres    false            �            1259    16434    id_cartaocredito    SEQUENCE     y   CREATE SEQUENCE public.id_cartaocredito
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.id_cartaocredito;
       public          postgres    false            �            1259    16436 
   id_cliente    SEQUENCE     s   CREATE SEQUENCE public.id_cliente
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 !   DROP SEQUENCE public.id_cliente;
       public          postgres    false            �            1259    16438 	   id_compra    SEQUENCE     �   CREATE SEQUENCE public.id_compra
    AS integer
    START WITH 1000
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.id_compra;
       public          postgres    false            �            1259    16440    id_endereco    SEQUENCE     t   CREATE SEQUENCE public.id_endereco
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.id_endereco;
       public          postgres    false            �            1259    16442    id_game    SEQUENCE     p   CREATE SEQUENCE public.id_game
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.id_game;
       public          postgres    false            �            1259    16444    id_item    SEQUENCE     p   CREATE SEQUENCE public.id_item
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.id_item;
       public          postgres    false            �            1259    16446    id_metodopagamento    SEQUENCE     {   CREATE SEQUENCE public.id_metodopagamento
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.id_metodopagamento;
       public          postgres    false            �            1259    16448 	   id_pacote    SEQUENCE     r   CREATE SEQUENCE public.id_pacote
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.id_pacote;
       public          postgres    false            �            1259    16450    id_preferencia    SEQUENCE     w   CREATE SEQUENCE public.id_preferencia
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.id_preferencia;
       public          postgres    false            �            1259    16452 	   id_status    SEQUENCE     r   CREATE SEQUENCE public.id_status
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.id_status;
       public          postgres    false            �            1259    16454    id_user    SEQUENCE     p   CREATE SEQUENCE public.id_user
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.id_user;
       public          postgres    false            �            1259    16456    img    TABLE     =   CREATE TABLE public.img (
    imgname text,
    img bytea
);
    DROP TABLE public.img;
       public         heap    postgres    false            �            1259    16462    log_cliente_alterado    TABLE     �  CREATE TABLE public.log_cliente_alterado (
    datahora date,
    id integer,
    situacao character varying NOT NULL,
    cpf character varying NOT NULL,
    nomecompleto character varying NOT NULL,
    datanascimento character varying NOT NULL,
    genero character varying NOT NULL,
    email character varying NOT NULL,
    senha character varying NOT NULL,
    celular character varying NOT NULL
);
 (   DROP TABLE public.log_cliente_alterado;
       public         heap    postgres    false            �            1259    16468    log_edicao_clientes    TABLE     �  CREATE TABLE public.log_edicao_clientes (
    id_antigo integer NOT NULL,
    situacao character varying NOT NULL,
    cpf_antigo character varying NOT NULL,
    nomecompleto_antigo character varying NOT NULL,
    datanascimento_antigo character varying NOT NULL,
    genero_antigo character varying NOT NULL,
    email_antigo character varying NOT NULL,
    senha_antigo character varying NOT NULL,
    celular_antigo character varying NOT NULL
);
 '   DROP TABLE public.log_edicao_clientes;
       public         heap    postgres    false            �            1259    16474    log_novo_cliente    TABLE     �  CREATE TABLE public.log_novo_cliente (
    datahora date,
    id integer,
    situacao character varying,
    cpf character varying NOT NULL,
    nomecompleto character varying NOT NULL,
    datanascimento character varying NOT NULL,
    genero character varying NOT NULL,
    email character varying NOT NULL,
    senha character varying NOT NULL,
    celular character varying NOT NULL
);
 $   DROP TABLE public.log_novo_cliente;
       public         heap    postgres    false            �            1259    16480    metodopagamento    TABLE     h   CREATE TABLE public.metodopagamento (
    id integer NOT NULL,
    metodo character varying NOT NULL
);
 #   DROP TABLE public.metodopagamento;
       public         heap    postgres    false            �            1259    16486    pacote    TABLE     e  CREATE TABLE public.pacote (
    id integer NOT NULL,
    nome character varying NOT NULL,
    gamefk integer NOT NULL,
    camisetafk integer NOT NULL,
    brindefk1 integer NOT NULL,
    brindefk2 integer,
    brindefk3 integer,
    brindefk4 integer,
    brindefk5 integer,
    situacao character varying NOT NULL,
    preco double precision NOT NULL
);
    DROP TABLE public.pacote;
       public         heap    postgres    false            �            1259    16492    preferencia    TABLE       CREATE TABLE public.preferencia (
    id integer NOT NULL,
    preferencia1 character varying NOT NULL,
    preferencia2 character varying NOT NULL,
    preferencia3 character varying NOT NULL,
    horasjogo character varying NOT NULL,
    jogoonline character varying NOT NULL
);
    DROP TABLE public.preferencia;
       public         heap    postgres    false            �            1259    16498    produto    TABLE     X  CREATE TABLE public.produto (
    id integer NOT NULL,
    nome character varying NOT NULL,
    descricao character varying NOT NULL,
    imagem character varying,
    situacao character varying NOT NULL,
    quantidade integer NOT NULL,
    preco double precision NOT NULL,
    CONSTRAINT produto_quantidade_check CHECK ((quantidade >= 0))
);
    DROP TABLE public.produto;
       public         heap    postgres    false            �            1259    16505    status    TABLE     T   CREATE TABLE public.status (
    id integer NOT NULL,
    nome character varying
);
    DROP TABLE public.status;
       public         heap    postgres    false            �            1259    16511    usuario    TABLE       CREATE TABLE public.usuario (
    id integer NOT NULL,
    nome character varying(300) NOT NULL,
    login character varying(100) NOT NULL,
    pw character varying(100) NOT NULL,
    perfil character varying(50) NOT NULL,
    situacao character varying(20) NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �          0    24576 
   assinatura 
   TABLE DATA           5   COPY public.assinatura (id, nome, preco) FROM stdin;
    public          postgres    false    230   �v       �          0    16397    camiseta 
   TABLE DATA           k   COPY public.camiseta (id, nome, descricao, sexo, tamanho, imagem, situacao, quantidade, preco) FROM stdin;
    public          postgres    false    202   3w       �          0    16404    cartaocredito 
   TABLE DATA           n   COPY public.cartaocredito (id, numerocartao, nomeimpresso, validade, codigo, bandeira, clientefk) FROM stdin;
    public          postgres    false    203   �w       �          0    16410    cliente 
   TABLE DATA           �   COPY public.cliente (id, situacao, cpf, nomecompleto, datanascimento, genero, email, senha, celular, assinatura, cobranca) FROM stdin;
    public          postgres    false    204   �w       �          0    16416    compra 
   TABLE DATA           �   COPY public.compra (id, datahora, valor, statusfk, clientefk, enderecoentregafk, metodopagamentofk, cartaocreditofk) FROM stdin;
    public          postgres    false    205   �x       �          0    16419    endereco 
   TABLE DATA           d   COPY public.endereco (id, cep, rua, numero, complemento, bairro, cidade, uf, clientefk) FROM stdin;
    public          postgres    false    206   Cy       �          0    16425    games 
   TABLE DATA           e   COPY public.games (id, nome, descricao, plataforma, imagem, situacao, quantidade, preco) FROM stdin;
    public          postgres    false    207   �y       �          0    16456    img 
   TABLE DATA           +   COPY public.img (imgname, img) FROM stdin;
    public          postgres    false    220   z       �          0    16462    log_cliente_alterado 
   TABLE DATA           �   COPY public.log_cliente_alterado (datahora, id, situacao, cpf, nomecompleto, datanascimento, genero, email, senha, celular) FROM stdin;
    public          postgres    false    221   ;z       �          0    16468    log_edicao_clientes 
   TABLE DATA           �   COPY public.log_edicao_clientes (id_antigo, situacao, cpf_antigo, nomecompleto_antigo, datanascimento_antigo, genero_antigo, email_antigo, senha_antigo, celular_antigo) FROM stdin;
    public          postgres    false    222   {       �          0    16474    log_novo_cliente 
   TABLE DATA           �   COPY public.log_novo_cliente (datahora, id, situacao, cpf, nomecompleto, datanascimento, genero, email, senha, celular) FROM stdin;
    public          postgres    false    223   :{       �          0    16480    metodopagamento 
   TABLE DATA           5   COPY public.metodopagamento (id, metodo) FROM stdin;
    public          postgres    false    224   �{       �          0    16486    pacote 
   TABLE DATA           �   COPY public.pacote (id, nome, gamefk, camisetafk, brindefk1, brindefk2, brindefk3, brindefk4, brindefk5, situacao, preco) FROM stdin;
    public          postgres    false    225   (|       �          0    16492    preferencia 
   TABLE DATA           j   COPY public.preferencia (id, preferencia1, preferencia2, preferencia3, horasjogo, jogoonline) FROM stdin;
    public          postgres    false    226   �|       �          0    16498    produto 
   TABLE DATA           [   COPY public.produto (id, nome, descricao, imagem, situacao, quantidade, preco) FROM stdin;
    public          postgres    false    227   }       �          0    16505    status 
   TABLE DATA           *   COPY public.status (id, nome) FROM stdin;
    public          postgres    false    228   �}       �          0    16511    usuario 
   TABLE DATA           H   COPY public.usuario (id, nome, login, pw, perfil, situacao) FROM stdin;
    public          postgres    false    229   R~       �           0    0    id_assinatura    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.id_assinatura', 3, true);
          public          postgres    false    231            �           0    0    id_camiseta    SEQUENCE SET     9   SELECT pg_catalog.setval('public.id_camiseta', 1, true);
          public          postgres    false    208            �           0    0    id_cartaocredito    SEQUENCE SET     >   SELECT pg_catalog.setval('public.id_cartaocredito', 1, true);
          public          postgres    false    209            �           0    0 
   id_cliente    SEQUENCE SET     9   SELECT pg_catalog.setval('public.id_cliente', 14, true);
          public          postgres    false    210            �           0    0 	   id_compra    SEQUENCE SET     :   SELECT pg_catalog.setval('public.id_compra', 1037, true);
          public          postgres    false    211            �           0    0    id_endereco    SEQUENCE SET     9   SELECT pg_catalog.setval('public.id_endereco', 1, true);
          public          postgres    false    212            �           0    0    id_game    SEQUENCE SET     6   SELECT pg_catalog.setval('public.id_game', 1, false);
          public          postgres    false    213            �           0    0    id_item    SEQUENCE SET     5   SELECT pg_catalog.setval('public.id_item', 9, true);
          public          postgres    false    214            �           0    0    id_metodopagamento    SEQUENCE SET     @   SELECT pg_catalog.setval('public.id_metodopagamento', 2, true);
          public          postgres    false    215            �           0    0 	   id_pacote    SEQUENCE SET     7   SELECT pg_catalog.setval('public.id_pacote', 5, true);
          public          postgres    false    216            �           0    0    id_preferencia    SEQUENCE SET     <   SELECT pg_catalog.setval('public.id_preferencia', 3, true);
          public          postgres    false    217            �           0    0 	   id_status    SEQUENCE SET     7   SELECT pg_catalog.setval('public.id_status', 5, true);
          public          postgres    false    218            �           0    0    id_user    SEQUENCE SET     5   SELECT pg_catalog.setval('public.id_user', 3, true);
          public          postgres    false    219            �
           2606    16518     log_edicao_clientes id_clientepk 
   CONSTRAINT     e   ALTER TABLE ONLY public.log_edicao_clientes
    ADD CONSTRAINT id_clientepk PRIMARY KEY (id_antigo);
 J   ALTER TABLE ONLY public.log_edicao_clientes DROP CONSTRAINT id_clientepk;
       public            postgres    false    222                       2606    24583    assinatura idassinaturapk 
   CONSTRAINT     W   ALTER TABLE ONLY public.assinatura
    ADD CONSTRAINT idassinaturapk PRIMARY KEY (id);
 C   ALTER TABLE ONLY public.assinatura DROP CONSTRAINT idassinaturapk;
       public            postgres    false    230            �
           2606    16520    camiseta idcamisetapk 
   CONSTRAINT     S   ALTER TABLE ONLY public.camiseta
    ADD CONSTRAINT idcamisetapk PRIMARY KEY (id);
 ?   ALTER TABLE ONLY public.camiseta DROP CONSTRAINT idcamisetapk;
       public            postgres    false    202            �
           2606    16522    cartaocredito idcartaocreditopk 
   CONSTRAINT     ]   ALTER TABLE ONLY public.cartaocredito
    ADD CONSTRAINT idcartaocreditopk PRIMARY KEY (id);
 I   ALTER TABLE ONLY public.cartaocredito DROP CONSTRAINT idcartaocreditopk;
       public            postgres    false    203            �
           2606    16524    cliente idclientepk 
   CONSTRAINT     Q   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT idclientepk PRIMARY KEY (id);
 =   ALTER TABLE ONLY public.cliente DROP CONSTRAINT idclientepk;
       public            postgres    false    204            �
           2606    16526    compra idcomprapk 
   CONSTRAINT     O   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT idcomprapk PRIMARY KEY (id);
 ;   ALTER TABLE ONLY public.compra DROP CONSTRAINT idcomprapk;
       public            postgres    false    205            �
           2606    16528    endereco idenderecopk 
   CONSTRAINT     S   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT idenderecopk PRIMARY KEY (id);
 ?   ALTER TABLE ONLY public.endereco DROP CONSTRAINT idenderecopk;
       public            postgres    false    206            �
           2606    16530    games idgamepk 
   CONSTRAINT     L   ALTER TABLE ONLY public.games
    ADD CONSTRAINT idgamepk PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.games DROP CONSTRAINT idgamepk;
       public            postgres    false    207            �
           2606    16532    metodopagamento idmeiopgtopk 
   CONSTRAINT     Z   ALTER TABLE ONLY public.metodopagamento
    ADD CONSTRAINT idmeiopgtopk PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.metodopagamento DROP CONSTRAINT idmeiopgtopk;
       public            postgres    false    224            �
           2606    16534    pacote idpacotepk 
   CONSTRAINT     O   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT idpacotepk PRIMARY KEY (id);
 ;   ALTER TABLE ONLY public.pacote DROP CONSTRAINT idpacotepk;
       public            postgres    false    225                       2606    16536    usuario idpk 
   CONSTRAINT     J   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT idpk PRIMARY KEY (id);
 6   ALTER TABLE ONLY public.usuario DROP CONSTRAINT idpk;
       public            postgres    false    229                       2606    16538    produto idpk_produto 
   CONSTRAINT     R   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT idpk_produto PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT idpk_produto;
       public            postgres    false    227                        2606    16540    preferencia idpreferenciapk 
   CONSTRAINT     Y   ALTER TABLE ONLY public.preferencia
    ADD CONSTRAINT idpreferenciapk PRIMARY KEY (id);
 E   ALTER TABLE ONLY public.preferencia DROP CONSTRAINT idpreferenciapk;
       public            postgres    false    226                       2606    16542    status idstatuspk 
   CONSTRAINT     O   ALTER TABLE ONLY public.status
    ADD CONSTRAINT idstatuspk PRIMARY KEY (id);
 ;   ALTER TABLE ONLY public.status DROP CONSTRAINT idstatuspk;
       public            postgres    false    228                       2620    16543 "   cliente data_cadastro_novo_cliente    TRIGGER        CREATE TRIGGER data_cadastro_novo_cliente AFTER INSERT ON public.cliente FOR EACH ROW EXECUTE FUNCTION public.data_cadastro();
 ;   DROP TRIGGER data_cadastro_novo_cliente ON public.cliente;
       public          postgres    false    232    204                       2620    16544    cliente executa_backup_clientes    TRIGGER     �   CREATE TRIGGER executa_backup_clientes AFTER UPDATE ON public.cliente FOR EACH ROW EXECUTE FUNCTION public.log_clientes_alterados();
 8   DROP TRIGGER executa_backup_clientes ON public.cliente;
       public          postgres    false    233    204                       2606    16545    pacote brindefk1    FK CONSTRAINT     s   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT brindefk1 FOREIGN KEY (brindefk1) REFERENCES public.produto(id);
 :   ALTER TABLE ONLY public.pacote DROP CONSTRAINT brindefk1;
       public          postgres    false    225    227    2818                       2606    16550    pacote brindefk2    FK CONSTRAINT     s   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT brindefk2 FOREIGN KEY (brindefk2) REFERENCES public.produto(id);
 :   ALTER TABLE ONLY public.pacote DROP CONSTRAINT brindefk2;
       public          postgres    false    2818    227    225                       2606    16555    pacote brindefk3    FK CONSTRAINT     s   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT brindefk3 FOREIGN KEY (brindefk3) REFERENCES public.produto(id);
 :   ALTER TABLE ONLY public.pacote DROP CONSTRAINT brindefk3;
       public          postgres    false    225    2818    227                       2606    16560    pacote brindefk4    FK CONSTRAINT     s   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT brindefk4 FOREIGN KEY (brindefk4) REFERENCES public.produto(id);
 :   ALTER TABLE ONLY public.pacote DROP CONSTRAINT brindefk4;
       public          postgres    false    2818    227    225                       2606    16565    pacote brindefk5    FK CONSTRAINT     s   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT brindefk5 FOREIGN KEY (brindefk5) REFERENCES public.produto(id);
 :   ALTER TABLE ONLY public.pacote DROP CONSTRAINT brindefk5;
       public          postgres    false    225    2818    227                       2606    16570    pacote camisetafk    FK CONSTRAINT     v   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT camisetafk FOREIGN KEY (camisetafk) REFERENCES public.camiseta(id);
 ;   ALTER TABLE ONLY public.pacote DROP CONSTRAINT camisetafk;
       public          postgres    false    2798    202    225            
           2606    16575    compra cartaocreditofk    FK CONSTRAINT     �   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT cartaocreditofk FOREIGN KEY (cartaocreditofk) REFERENCES public.cartaocredito(id);
 @   ALTER TABLE ONLY public.compra DROP CONSTRAINT cartaocreditofk;
       public          postgres    false    2800    203    205            	           2606    16580    cartaocredito clientefk    FK CONSTRAINT     z   ALTER TABLE ONLY public.cartaocredito
    ADD CONSTRAINT clientefk FOREIGN KEY (clientefk) REFERENCES public.cliente(id);
 A   ALTER TABLE ONLY public.cartaocredito DROP CONSTRAINT clientefk;
       public          postgres    false    2802    204    203                       2606    16585    endereco clientefk    FK CONSTRAINT     u   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT clientefk FOREIGN KEY (clientefk) REFERENCES public.cliente(id);
 <   ALTER TABLE ONLY public.endereco DROP CONSTRAINT clientefk;
       public          postgres    false    2802    204    206                       2606    16590    compra clientefk    FK CONSTRAINT     s   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT clientefk FOREIGN KEY (clientefk) REFERENCES public.cliente(id);
 :   ALTER TABLE ONLY public.compra DROP CONSTRAINT clientefk;
       public          postgres    false    205    2802    204                       2606    16595    compra enderecoentregafk    FK CONSTRAINT     �   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT enderecoentregafk FOREIGN KEY (enderecoentregafk) REFERENCES public.endereco(id);
 B   ALTER TABLE ONLY public.compra DROP CONSTRAINT enderecoentregafk;
       public          postgres    false    206    205    2806                       2606    16600    pacote gamefk    FK CONSTRAINT     k   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT gamefk FOREIGN KEY (gamefk) REFERENCES public.games(id);
 7   ALTER TABLE ONLY public.pacote DROP CONSTRAINT gamefk;
       public          postgres    false    2808    225    207                       2606    16605    compra metodopagamentofk    FK CONSTRAINT     �   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT metodopagamentofk FOREIGN KEY (metodopagamentofk) REFERENCES public.metodopagamento(id);
 B   ALTER TABLE ONLY public.compra DROP CONSTRAINT metodopagamentofk;
       public          postgres    false    224    205    2812                       2606    16610    compra statusfk    FK CONSTRAINT     p   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT statusfk FOREIGN KEY (statusfk) REFERENCES public.status(id);
 9   ALTER TABLE ONLY public.compra DROP CONSTRAINT statusfk;
       public          postgres    false    2820    205    228            �   .   x�3�t
���r�45�2�rq�43�2����47������ ��R      �   Z   x���tN��,N-I�J�II��M,N.��������M�t��紴�42�2�)��Cb�apj�B���CkKJs��
�`�@c���� � L      �   7   x�3�D�A�y�%�
�9I�E%��FF��fff����%�EΉE)�F\1z\\\ ޣu      �   �   x�eMA
�0<o^�l�6�to�(bO��h�i�V��mko;;;��Pގ����1V*.P[���M1{Ƭr�~����qꀘ-�Be3T9�a\�n=�R�6N�u�lb��D���w�Y+��y��<�$7bJpr�_�
��@�f��.�H�R�ե6[      �   �   x���A
� D�z�~2�Z��?A���5���z/q��IEe���R���s2D��*�z�<l����T!Ԟ�{eaL��h3���-�Z �z(T/D��3�3aA��T0A��ɫ������x#|'�>����Ar@	7��@#�g��/�|A��      �   X   x�3�072013�*MTp��M�LIT�:�|hW^f~��)��c�#gXfN��sbAiIjQ"�o~z�BJb��sQiUj1gp �W� �v,      �   c   x�3�t�OQ�OSO,R����L*��KI��IMO�����M�t���440�4�2�tqTCU��_��҂ӥ(1=?O�)1'G!
�dg$� �1z\\\ {�'�      �      x������ � �      �   �   x������0���)�2I�vn� ��*{�݂�րVH���*��*x�l`���J*���4��l1��30)	c!9E��g�����]<��uQ��++W��.���3��(L`�MۮMR�7��lQ�����D��|�P�����P�O�z@�gｸzM���ֶ����f�p�������m��.���0��ۣ�� I�\�(�N �L      �      x������ � �      �   �   x��ο� ��x
_�`ok�:8���qP�6]������|�@��O	%P*��q.��0��9�k�9�ރ$�(�s�A��!���|��{�e��!�ɛ��ﲯ[?��5B:6~�C�\�ڀ-�iU�t7������ݣ/��m�4yW���q���5c[      �   )   x�3�t��I-��2�tN,*I�WHIUp.JM����qqq ��	�      �   t   x�3��/-��4��4�4�4�4�4�t,�,��42�24�t*�ϫJ�*��C �".CC�f�pYp%�$"I#�75�2¥ �3̟�Ԍ�F�T��TX�Ra���#`5&�\1z\\\ ��:�      �   E   x�3�t,K�+)-J�
p�t-.)J,IM�L�4THT0R�(*����2"R�1B�Oi	D�ob&D2F��� �T"       �   �   x�}O۪�0|�|�~��^�Q�A��EY��Fc�V�|s>�>��3](�
a��
�D����/�+r`_L���-dZC6Ъ���ɼ�U#��{��$x iM�����j�I��k�f,(FL��[���Z ��;�8�ec����#�DⳭd�2��sI8�ҟ)9�+1����QJ}	4`?      �   u   x�E�;�@D��)|�q$�4C�Z"�r6�g��f�٥K����`5v���h�����!�m	�er�O|іk�&����Z2����7k)��y]��^^�M݆�>.A4F      �   R   x�3�tt����,J�K,��L�IJ-*��y�9��q:�x��sAUf'�&r���cUe3/?�(3=�3;5/+��=... #t     