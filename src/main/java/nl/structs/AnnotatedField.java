
package main.java.nl.structs;

import java.util.LinkedList;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexOptions;

public class AnnotatedField extends Field {

    /** Indexed, tokenized, stored. */
    public static final FieldType TYPE_STORED = new FieldType();

    private LinkedList<AnnotateFilter.Annotation> annotations;

    static {

      // TODO: do we need the offsets?

      TYPE_STORED.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
      TYPE_STORED.setTokenized(false);
      TYPE_STORED.setStored(true);
      TYPE_STORED.setStoreTermVectors(true);
      TYPE_STORED.setStoreTermVectorOffsets(true);
      TYPE_STORED.setStoreTermVectorPositions(true);
      TYPE_STORED.setStoreTermVectorPayloads(true);

      TYPE_STORED.freeze();
    }

    public AnnotatedField(String name, String value, LinkedList<AnnotateFilter.Annotation> annotations) {
    
      // TODO: are there also unstored scenario's?
      // TODO: what about adding other values: Reader, bytes, ect? Adding a tokenstream directly assumes an unstored value

      super(name,value, TYPE_STORED);
      this.annotations = annotations;
    }

    @Override
    public TokenStream tokenStream(Analyzer analyzer, TokenStream reuse) {

      var ts = analyzer.tokenStream(name(), stringValue());
      //ts = new AnnotateFilter(ts, this.annotations);
      ts = new PayloadTokenLengthFilter(ts);

      return ts;
    }

  }