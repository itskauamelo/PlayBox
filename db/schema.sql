PGDMP     $    7            	    x         	   dbplaybox    12.4    12.4 E    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
    cobranca character varying,
    assinaturafk integer
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
       public         heap    postgres    false            �            1259    16486    pacote    TABLE     �  CREATE TABLE public.pacote (
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
    preco double precision NOT NULL,
    quantidade integer,
    assinaturafk integer
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
       public         heap    postgres    false            �
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
       public            postgres    false    228                       2620    16543 "   cliente data_cadastro_novo_cliente    TRIGGER        CREATE TRIGGER data_cadastro_novo_cliente AFTER INSERT ON public.cliente FOR EACH ROW EXECUTE FUNCTION public.data_cadastro();
 ;   DROP TRIGGER data_cadastro_novo_cliente ON public.cliente;
       public          postgres    false    204    232                       2620    16544    cliente executa_backup_clientes    TRIGGER     �   CREATE TRIGGER executa_backup_clientes AFTER UPDATE ON public.cliente FOR EACH ROW EXECUTE FUNCTION public.log_clientes_alterados();
 8   DROP TRIGGER executa_backup_clientes ON public.cliente;
       public          postgres    false    204    233            
           2606    32768    cliente assinaturafk    FK CONSTRAINT     }   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT assinaturafk FOREIGN KEY (assinaturafk) REFERENCES public.assinatura(id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT assinaturafk;
       public          postgres    false    204    230    2824                       2606    32773    pacote assinaturafk    FK CONSTRAINT     |   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT assinaturafk FOREIGN KEY (assinaturafk) REFERENCES public.assinatura(id);
 =   ALTER TABLE ONLY public.pacote DROP CONSTRAINT assinaturafk;
       public          postgres    false    2824    225    230                       2606    16545    pacote brindefk1    FK CONSTRAINT     s   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT brindefk1 FOREIGN KEY (brindefk1) REFERENCES public.produto(id);
 :   ALTER TABLE ONLY public.pacote DROP CONSTRAINT brindefk1;
       public          postgres    false    2818    227    225                       2606    16550    pacote brindefk2    FK CONSTRAINT     s   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT brindefk2 FOREIGN KEY (brindefk2) REFERENCES public.produto(id);
 :   ALTER TABLE ONLY public.pacote DROP CONSTRAINT brindefk2;
       public          postgres    false    227    225    2818                       2606    16555    pacote brindefk3    FK CONSTRAINT     s   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT brindefk3 FOREIGN KEY (brindefk3) REFERENCES public.produto(id);
 :   ALTER TABLE ONLY public.pacote DROP CONSTRAINT brindefk3;
       public          postgres    false    227    2818    225                       2606    16560    pacote brindefk4    FK CONSTRAINT     s   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT brindefk4 FOREIGN KEY (brindefk4) REFERENCES public.produto(id);
 :   ALTER TABLE ONLY public.pacote DROP CONSTRAINT brindefk4;
       public          postgres    false    225    2818    227                       2606    16565    pacote brindefk5    FK CONSTRAINT     s   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT brindefk5 FOREIGN KEY (brindefk5) REFERENCES public.produto(id);
 :   ALTER TABLE ONLY public.pacote DROP CONSTRAINT brindefk5;
       public          postgres    false    225    227    2818                       2606    16570    pacote camisetafk    FK CONSTRAINT     v   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT camisetafk FOREIGN KEY (camisetafk) REFERENCES public.camiseta(id);
 ;   ALTER TABLE ONLY public.pacote DROP CONSTRAINT camisetafk;
       public          postgres    false    225    2798    202                       2606    16575    compra cartaocreditofk    FK CONSTRAINT     �   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT cartaocreditofk FOREIGN KEY (cartaocreditofk) REFERENCES public.cartaocredito(id);
 @   ALTER TABLE ONLY public.compra DROP CONSTRAINT cartaocreditofk;
       public          postgres    false    203    2800    205            	           2606    16580    cartaocredito clientefk    FK CONSTRAINT     z   ALTER TABLE ONLY public.cartaocredito
    ADD CONSTRAINT clientefk FOREIGN KEY (clientefk) REFERENCES public.cliente(id);
 A   ALTER TABLE ONLY public.cartaocredito DROP CONSTRAINT clientefk;
       public          postgres    false    203    204    2802                       2606    16585    endereco clientefk    FK CONSTRAINT     u   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT clientefk FOREIGN KEY (clientefk) REFERENCES public.cliente(id);
 <   ALTER TABLE ONLY public.endereco DROP CONSTRAINT clientefk;
       public          postgres    false    2802    206    204                       2606    16590    compra clientefk    FK CONSTRAINT     s   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT clientefk FOREIGN KEY (clientefk) REFERENCES public.cliente(id);
 :   ALTER TABLE ONLY public.compra DROP CONSTRAINT clientefk;
       public          postgres    false    2802    204    205                       2606    16595    compra enderecoentregafk    FK CONSTRAINT     �   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT enderecoentregafk FOREIGN KEY (enderecoentregafk) REFERENCES public.endereco(id);
 B   ALTER TABLE ONLY public.compra DROP CONSTRAINT enderecoentregafk;
       public          postgres    false    206    205    2806                       2606    16600    pacote gamefk    FK CONSTRAINT     k   ALTER TABLE ONLY public.pacote
    ADD CONSTRAINT gamefk FOREIGN KEY (gamefk) REFERENCES public.games(id);
 7   ALTER TABLE ONLY public.pacote DROP CONSTRAINT gamefk;
       public          postgres    false    207    225    2808                       2606    16605    compra metodopagamentofk    FK CONSTRAINT     �   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT metodopagamentofk FOREIGN KEY (metodopagamentofk) REFERENCES public.metodopagamento(id);
 B   ALTER TABLE ONLY public.compra DROP CONSTRAINT metodopagamentofk;
       public          postgres    false    205    224    2812                       2606    16610    compra statusfk    FK CONSTRAINT     p   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT statusfk FOREIGN KEY (statusfk) REFERENCES public.status(id);
 9   ALTER TABLE ONLY public.compra DROP CONSTRAINT statusfk;
       public          postgres    false    228    2820    205           