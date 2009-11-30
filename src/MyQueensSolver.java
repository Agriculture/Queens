import queens.base.*;

// Dieses ist ein leeres Gerüst, welches das zu implementierende
// Interface implementiert.
//
// Es geht darum, eine gegebene Damenanzahl N so auf einem N*N-Schachbrett zu verteilen,
// dass sich die Damen nach den Schachregeln nicht gegenseitig bedrohen.
// Im Schach kann jede Dame waagerecht, senkrecht oder diagonal bis maximal zum
// nächsten Rand gezogen werden, d.h. es darf weder in ihrer Spalte, noch in
// ihrer Zeile noch in einer ihrer ein oder zwei Diagonalen eine andere Dame stehen.
//
// Die Damenanzahl kann am oberen Fensterrand eingestellt werden. Die Funktionen
// bekommen die eingestellte Damenanzahl jeweils im Parameter queenCnt mitgeteilt.
//
// Zur Lösung sind zwei verschiedene Hillclimbing-Algorithmen zu verwenden, die
// -> a): First-Choice verwenden, d.h. der erste Zug, der irgendeine Verbesserung
//        bringt wird gewählt
// -> b): Best-Choice verwenden, d.h. es werden alle Zugmöglichkeiten durchsucht,
//        daraus wird diejenige gewählt, die die meiste Verbesserung bringt (falls
//        es mindestens einen Verbesserungszug gibt), falls mehrere Züge die selbe
//        beste Verbesserung bringen, wird davon zufällig einer ausgewählt
// Die Auswahl über den zu verwendenden Algorithmus kann am oberen Fensterrand
// eingestellt werden.
// Die Funktionen bekommen die eingestellte Hillclimbingstrategie über den boolschen
// Parameter useFirstChoice mitgeteilt, d.h. wenn useFirstChoice true ist, ist First-Choice
// zu verwenden, ansonsten Best-Choice.
//
// Ein weiteres entscheidendes Merkmal eines Hillclimbingalgorithmus ist das Verhalten,
// wenn aus dem aktuellen Zustand heraus keine Verbesserung mehr möglich ist, es jedoch
// erreichbare genausogute Zustände gibt. In diesem Fall sind mehrere Strategien
// möglich:
// a): Suche abbrechen. Damit verschenkt man die Chance, ein paar Züge weiter vielleicht
//     doch noch einen Aufwärtszug zu finden.
// b): Suche fortsetzen. Dies darf in jedem Fall nicht beliebig lange geschehen,
//     da man sonst bei ebenen Maxima in eine Endlosschleife gerät. Aus diesem
//     Grund werden die hintereinander ausgeführten Züge ohne Bewertungsverbesserung
//     (die sogenannten Seitschritte) auf ein Maximum begrenzt. Ist nach dieser
//     Anzahl an Seitschritten kein verbessernder Zug gefunden, so ist die Suche abzubrechen.
//     Weiterhin ist bei den Seitschritten eine Zufallsauswahl zwingend nötig, da
//     ansonsten oft zwischen wenigen Zügen hin und her gesprungen wird.
//     In diesem Fall hat man die Chance, noch eine Verbesserung zu finden, dafür
//     muss man pro Lösungsversuch (auch pro erfolglosem Lösungsversuch) deutlich
//     mehr Schritte unternehmen.
public class MyQueensSolver implements IQueensSolver
{
    // Die erste Aufgabe ist es, für eine bestimmte Damenanzahl (queenCount),
    // eine Hillclimbingstrategie (firstChoice) und eine erlaubte Anzahl an sukzessiven
    // Seitschritten (allowedSideSteps) einen Lösungsversuch zu unternehmen.
    // Die Oberfläche für die Bedienung der ersten Aufgabe findet sich unter der
    // Karteilasche "Einzellösung". Hier kann auch die Seitschrittbeschränkung
    // eingestellt werden.
    // Das Ergebnis (gelöst/nicht gelöst, bei gelöst: tatsächliche Lösung) und
    // eine kleine Statistik (Anzahl der beim Lösungsversuch unternommenen Schritte)
    // ist im SolveErg zusammenzustellen.
    // Im Falle einer erfolgreichen Lösung ist die gültige Damenbelegung in Form eines
    // Integer-Arrays zurückzugeben, wobei jedes Feld des Arrays die Position einer
    // Dame in ihrer Spalte repräsentiert, d.h. solution[]={0,2,1} bei einem
    // 3-Damen-Problem würde bedeuten, dass die erste Dame (in der ersten Spalte)
    // ganz unten (auf Zeile 0) steht, die mittlere Dame steht ganz oben (auf
    // Zeile 2) und die rechte Dame steht in der mittleren Zeile.
    public SolveErg solveNQueens(int queenCount, boolean useFirstChoice, int allowedSideSteps)
    {
        //1. zufälliges N-Damen-Problem erstellen:
        // problem=makeRandomNQueens(queenCount)

        //2. je nach den Parametern, versuchen das zu lösen
        //if(firstChoice)
        //   solveFirstChoice(problem,allowedSideSteps)
        //else
        //   solveBestChoice(problem,allowedSideSteps)

        //3. Statistik und Ergebnisse zurückgeben
        //int schritte=getSteps()
        //if(gelöst)
        //    return SolveErg.makeErgForSolvable(schritte, getSolutionQueenPositions())
        //else
        //     return SolveErg.makeErgForUnsolvable(schritte)
        return SolveErg.makeErgForUnsolvable(0);
    }

    // Die zweite Aufgabe ist es herauszufinden, ob pro Damenanzahl eine optimale Seitschrittanzahl
    // existiert und diese herauszufinden.
    // Die zugehörige Oberfläche findet sich unter der Kateilasche "Statistik".
    // Das Problem wird wieder spezifiziert über die Damenanzahl (queenCount) und die
    // Hillclimbingstrategie (firstChoice)
    // Mit diesem Parametern sollen mehrere Versuche (tryCount - einstellbar oben auf der Karteilasche)
    // unternommen werden, mit verschiedenen Seitschrittbeschränkungen (0 bis 100) das Problem zu lösen.
    // Danach kann dann abgeschätzt werden, wie viele Züge man durchschnittlich benötigt (inklusive
    // erfolgloser Versuche), um eine Lösung zu finden. Dieser durchschnittlicher Zugwert ist für
    // jede erlaubte Seitschrittanzahl in ein double-Array einzutragen und zurückzugeben. Sie wird
    // in einem einfachen Diagramm dargestellt, auch der Maximal- und Minimalwert werden angezeigt.
    public double[] getAvgStepsPerSuccessfulSolution(int queenCount, boolean useFirstChoice, int tryCount)
    {
        double[] statistik=new double[101];

        //für alle erlaubten Seitenschrittanzahlen von 0 bis einschliesslich 100:
        //    1.bestimme durch tryCount Versuche, die durchschnittlich nötige Zugzahl, um
        //    eine Lösung zu finden.
        //    2. trage diesen Wert in das Array ein.
        //    Bsp.: für einen erlaubten Seitschritt wurde bestimmt, dass durchschnittlich
        //          30.53 Züge nötig sind.
        //   -> statistik[1]=30.53;

        return statistik;
    }
}
