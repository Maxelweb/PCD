package pcd2018.exe2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Classe da completare per l'esercizio 2.
 */
public class DiffieHellman {

  /**
   * Limite massimo dei valori segreti da cercare
   */
  private static final int LIMIT = 65536;

  private final long p;
  private final long g;

  public DiffieHellman(long p, long g) {
    this.p = p;
    this.g = g;
  }

  /**
   * Metodo da completare
   * 
   * @param publicA valore di A
   * @param publicB valore di B
   * @return tutte le coppie di possibili segreti a,b
   */
  public List<Integer> crack(long publicA, long publicB)
  {
    // =================================
    // Configurazione degli array per i calcoli e i risultati
    // =================================

    List<Integer> res = new ArrayList<Integer>();

    HashMap<Character, List<Long>> calcoli = new HashMap<>();

    ArrayList<Long> arrayNotThreadSafeA = new ArrayList<>();
    ArrayList<Long> arrayNotThreadSafeB = new ArrayList<>();

    List<Long> ThreadSafeA = Collections.synchronizedList(arrayNotThreadSafeA);
    List<Long> ThreadSafeB = Collections.synchronizedList(arrayNotThreadSafeB);

    calcoli.put('a', ThreadSafeA);
    calcoli.put('b', ThreadSafeB);

    // =================================
    // Configurazione della scalabilità
    // =================================

    int NumberOfCores = Runtime.getRuntime().availableProcessors();
    int NumberOfThreads = NumberOfCores * 4;

    ExecutorService EsecutoreDeiThreads = Executors.newFixedThreadPool(NumberOfThreads);

    // =================================
    // Configurazione della quantità di lavoro per ciascun thread
    // =================================

    

    // =================================
    return res;
  }
}
