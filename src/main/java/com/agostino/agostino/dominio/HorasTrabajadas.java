package com.agostino.agostino.dominio;

public class HorasTrabajadas {
        private long totalHours;
        private long nocturnalHours;
    
        public HorasTrabajadas(long totalHours, long nocturnalHours) {
            this.totalHours = totalHours;
            this.nocturnalHours = nocturnalHours;
        }
    
        public long getTotalHours() {
            return totalHours;
        }
    
        public long getNocturnalHours() {
            return nocturnalHours;
        }
    }
