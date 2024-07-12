package com.agostino.agostino.dominio;

public class HorasTrabajadas {
        private long totalHours;
        private long nocturnalHours;
        private long feriadoHours;
    
        public HorasTrabajadas(long totalHours, long nocturnalHours, long feriadoHours) {
            this.totalHours = totalHours;
            this.nocturnalHours = nocturnalHours;
            this.feriadoHours = feriadoHours;
        }
    
        public long getTotalHours() {
            return totalHours;
        }
    
        public long getNocturnalHours() {
            return nocturnalHours;
        }

        public long getFeriadoHours(){
            return feriadoHours;
        }
    }
