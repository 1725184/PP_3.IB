# PP_3.IB

ParalleleProgrammierung_Pflichtaufgaben

Pflichtaufgabe 1 (Testat 1)
  Abgabe spÃ¤testens am 18.10.2018 bis 13 Uhr (laut Moodle)

  Bauen Sie die (synchronisierten) dinierenden Philosophen um, so dass Bedingungsvariablen benutzt werden:

    Jeder Philosoph ist ein Thread und besitzt einen Warteraum, in dem die Nachbarphilosophen darauf warten, dass er seine StÃ¤bchen freigibt.
    Der Name der Klasse muss io.dama.par.dining.cond.Philosopher sein.
    Philosoph implementiert das Interface io.dama.par.dining.cond.IPhilosopher
    Jeder Philosoph hat je eine Referenz auf seinen linken und rechten Nachbarn.
        setLeft(IPhilosopher left); setRight(IPhilosopher right);
    Der Tisch wird durch ein ReentrantLock-Objekt (Interface Lock) reprÃ¤sentiert. Alle Philosophen mÃ¼ssen den Tisch verwenden, wenn sie     beginnen zu essen. Eine Referenz auf den Tisch kann mit dem Setter Ã¼bergeben werden:
        setTable(Lock table);
    MÃ¶chte ein Philosoph beginnen zu essen, prÃ¼ft er, ob sein linker Nachbar oder sein rechter Nachbar isst; er erwartet den Moment, in dem beide nicht essen. Dann beginnt er zu essen.
    Wenn ein Philosoph denkt, isst er nicht und signalisiert jeweils seinem linken Nachbarn und seinem rechten Nachbarn, dass er nicht isst.

Geben Sie eine Java-Datei (also nur den Quellcode) fÃ¼r die Klasse 

    io.dama.par.dining.cond.Philosopher

ab.

Importieren Sie das Eclipse Projekt 

https://drive.google.com/open?id=1dplu_UMfzmlYh_hnC1ffQuh-O2gWk_MB

mit  File -> Import -> General/Existing Projects Into Workspace
