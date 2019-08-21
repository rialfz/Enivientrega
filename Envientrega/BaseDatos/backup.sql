PGDMP     ,                    w            postgres    9.6.5    11.3 $    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    12401    postgres    DATABASE     �   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE postgres;
             postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                  postgres    false    2185                        2615    16394    envientrega    SCHEMA        CREATE SCHEMA envientrega;
    DROP SCHEMA envientrega;
             postgres    false            �            1259    16476    autoincrement_frecuencia    SEQUENCE     �   CREATE SEQUENCE envientrega.autoincrement_frecuencia
    START WITH 1
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE envientrega.autoincrement_frecuencia;
       envientrega       envientrega    false    6            �            1259    16455 
   frecuencia    TABLE     �   CREATE TABLE envientrega.frecuencia (
    dia_frecuencia date NOT NULL,
    id_frecuencia integer DEFAULT nextval('envientrega.autoincrement_frecuencia'::regclass) NOT NULL,
    estado_frecuencia integer NOT NULL
);
 #   DROP TABLE envientrega.frecuencia;
       envientrega         envientrega    false    195    6            �            1259    16425    id_rol    SEQUENCE     v   CREATE SEQUENCE envientrega.id_rol
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999
    CACHE 1;
 "   DROP SEQUENCE envientrega.id_rol;
       envientrega       envientrega    false    6            �            1259    16432    menu    TABLE     �   CREATE TABLE envientrega.menu (
    id_menu integer NOT NULL,
    comando_menu text NOT NULL,
    texto_menu text NOT NULL,
    icono_menu text
);
    DROP TABLE envientrega.menu;
       envientrega         envientrega    false    6            �            1259    16395    movil    TABLE     Q  CREATE TABLE envientrega.movil (
    nombre_movil text NOT NULL,
    telefono_movil text NOT NULL,
    direccion_movil text NOT NULL,
    codigo_movil integer NOT NULL,
    nombre_referencia_movil text NOT NULL,
    telefono_referencia_movil text NOT NULL,
    estado_movil integer NOT NULL,
    identificacion_movil numeric NOT NULL
);
    DROP TABLE envientrega.movil;
       envientrega         envientrega    false    6            �            1259    16460    movil_frecuencia    TABLE     �   CREATE TABLE envientrega.movil_frecuencia (
    identificacion_movil integer NOT NULL,
    id_frecuencia integer NOT NULL,
    estado_frecuencia integer NOT NULL
);
 )   DROP TABLE envientrega.movil_frecuencia;
       envientrega         envientrega    false    6            �            1259    16415    rol    TABLE     �   CREATE TABLE envientrega.rol (
    tipo_rol text NOT NULL,
    id_rol integer DEFAULT nextval('envientrega.id_rol'::regclass) NOT NULL
);
    DROP TABLE envientrega.rol;
       envientrega         envientrega    false    190    6            �            1259    16440    rol_menu    TABLE     a   CREATE TABLE envientrega.rol_menu (
    id_rol integer NOT NULL,
    id_menu integer NOT NULL
);
 !   DROP TABLE envientrega.rol_menu;
       envientrega         envientrega    false    6            �            1259    16407    usuario    TABLE     �   CREATE TABLE envientrega.usuario (
    identificacion_usuario numeric NOT NULL,
    nombre_usuario text NOT NULL,
    clave_usuario text NOT NULL,
    id_rol integer NOT NULL
);
     DROP TABLE envientrega.usuario;
       envientrega         envientrega    false    6            �          0    16455 
   frecuencia 
   TABLE DATA               [   COPY envientrega.frecuencia (dia_frecuencia, id_frecuencia, estado_frecuencia) FROM stdin;
    envientrega       envientrega    false    193   �)                 0    16432    menu 
   TABLE DATA               R   COPY envientrega.menu (id_menu, comando_menu, texto_menu, icono_menu) FROM stdin;
    envientrega       envientrega    false    191   -*       {          0    16395    movil 
   TABLE DATA               �   COPY envientrega.movil (nombre_movil, telefono_movil, direccion_movil, codigo_movil, nombre_referencia_movil, telefono_referencia_movil, estado_movil, identificacion_movil) FROM stdin;
    envientrega       envientrega    false    187   �*       �          0    16460    movil_frecuencia 
   TABLE DATA               g   COPY envientrega.movil_frecuencia (identificacion_movil, id_frecuencia, estado_frecuencia) FROM stdin;
    envientrega       envientrega    false    194   �*       }          0    16415    rol 
   TABLE DATA               4   COPY envientrega.rol (tipo_rol, id_rol) FROM stdin;
    envientrega       envientrega    false    189   *+       �          0    16440    rol_menu 
   TABLE DATA               8   COPY envientrega.rol_menu (id_rol, id_menu) FROM stdin;
    envientrega       envientrega    false    192   h+       |          0    16407    usuario 
   TABLE DATA               e   COPY envientrega.usuario (identificacion_usuario, nombre_usuario, clave_usuario, id_rol) FROM stdin;
    envientrega       envientrega    false    188   �+       �           0    0    autoincrement_frecuencia    SEQUENCE SET     L   SELECT pg_catalog.setval('envientrega.autoincrement_frecuencia', 15, true);
            envientrega       envientrega    false    195            �           0    0    id_rol    SEQUENCE SET     9   SELECT pg_catalog.setval('envientrega.id_rol', 3, true);
            envientrega       envientrega    false    190            �           2606    16459    frecuencia frecuencia_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY envientrega.frecuencia
    ADD CONSTRAINT frecuencia_pkey PRIMARY KEY (id_frecuencia);
 I   ALTER TABLE ONLY envientrega.frecuencia DROP CONSTRAINT frecuencia_pkey;
       envientrega         envientrega    false    193            �           2606    16439    menu menu_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY envientrega.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (id_menu);
 =   ALTER TABLE ONLY envientrega.menu DROP CONSTRAINT menu_pkey;
       envientrega         envientrega    false    191                        2606    16464 &   movil_frecuencia movil_frecuencia_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY envientrega.movil_frecuencia
    ADD CONSTRAINT movil_frecuencia_pkey PRIMARY KEY (identificacion_movil, id_frecuencia);
 U   ALTER TABLE ONLY envientrega.movil_frecuencia DROP CONSTRAINT movil_frecuencia_pkey;
       envientrega         envientrega    false    194    194            �           2606    16406    movil movil_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY envientrega.movil
    ADD CONSTRAINT movil_pkey PRIMARY KEY (identificacion_movil);
 ?   ALTER TABLE ONLY envientrega.movil DROP CONSTRAINT movil_pkey;
       envientrega         envientrega    false    187            �           2606    16444    rol_menu rol_menu_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY envientrega.rol_menu
    ADD CONSTRAINT rol_menu_pkey PRIMARY KEY (id_rol, id_menu);
 E   ALTER TABLE ONLY envientrega.rol_menu DROP CONSTRAINT rol_menu_pkey;
       envientrega         envientrega    false    192    192            �           2606    16424    rol rol_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY envientrega.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id_rol);
 ;   ALTER TABLE ONLY envientrega.rol DROP CONSTRAINT rol_pkey;
       envientrega         envientrega    false    189            �           2606    16414    usuario usuario_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY envientrega.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (identificacion_usuario);
 C   ALTER TABLE ONLY envientrega.usuario DROP CONSTRAINT usuario_pkey;
       envientrega         envientrega    false    188                       2606    16470    movil_frecuencia id_frecuencia    FK CONSTRAINT     �   ALTER TABLE ONLY envientrega.movil_frecuencia
    ADD CONSTRAINT id_frecuencia FOREIGN KEY (id_frecuencia) REFERENCES envientrega.frecuencia(id_frecuencia);
 M   ALTER TABLE ONLY envientrega.movil_frecuencia DROP CONSTRAINT id_frecuencia;
       envientrega       envientrega    false    194    193    2046                       2606    16450    rol_menu id_menu    FK CONSTRAINT     }   ALTER TABLE ONLY envientrega.rol_menu
    ADD CONSTRAINT id_menu FOREIGN KEY (id_menu) REFERENCES envientrega.menu(id_menu);
 ?   ALTER TABLE ONLY envientrega.rol_menu DROP CONSTRAINT id_menu;
       envientrega       envientrega    false    191    2042    192                       2606    16445    rol_menu id_rol    FK CONSTRAINT     y   ALTER TABLE ONLY envientrega.rol_menu
    ADD CONSTRAINT id_rol FOREIGN KEY (id_rol) REFERENCES envientrega.rol(id_rol);
 >   ALTER TABLE ONLY envientrega.rol_menu DROP CONSTRAINT id_rol;
       envientrega       envientrega    false    2040    192    189                       2606    16465 $   movil_frecuencia idntificacion_movil    FK CONSTRAINT     �   ALTER TABLE ONLY envientrega.movil_frecuencia
    ADD CONSTRAINT idntificacion_movil FOREIGN KEY (identificacion_movil) REFERENCES envientrega.movil(identificacion_movil);
 S   ALTER TABLE ONLY envientrega.movil_frecuencia DROP CONSTRAINT idntificacion_movil;
       envientrega       envientrega    false    187    194    2036                       2606    16427    usuario rol    FK CONSTRAINT     u   ALTER TABLE ONLY envientrega.usuario
    ADD CONSTRAINT rol FOREIGN KEY (id_rol) REFERENCES envientrega.rol(id_rol);
 :   ALTER TABLE ONLY envientrega.usuario DROP CONSTRAINT rol;
       envientrega       envientrega    false    2040    188    189            �   V   x�U���0Cѳ�%&�Iv��s�J=8�'��ù��� A��>�D?9�1�ʉ[�ʎ�Lle}��E�b�jXԱ���4���=���&�         W   x�3�T�N�,JM.���sJM��+J��5�s��2s�5k9}A�?.#��S�J��Z�!L�&c��Ҁ��Լ��D�>78�5F��� �8�      {   J   x��LN,J��442615�LN��I5�4��O˄	rr���d�rá!���W1PY"Hpq��qqq ���      �   ,   x�3�4�4�2�4�FP��1�2�P@�	�g�Bx *F��� 8      }   .   x�sN�+)J��4�rL����,�R�8�
�JS�9��b���� �      �      x�3�4�2�4�2��@ژ+F��� 'V�      |   K   x�3�3�LN�+)J�1�4�4�2
8��f�eS�89�La�LMM9M��L`&�&@��#N ����� ���     