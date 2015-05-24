/*
 * Copyright (C) 2015 Mattia Cerrato
 * Developed for Red Hen Lab <https://sites.google.com/site/distributedlittleredhen/>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package rhat.cli;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import rhat.task.AmbientDetector;
import rhat.task.BroadcastSegmenter;


/**
 *
 * @author mattia
 */
public class Rhat {

    private final static Logger LOG = Logger.getLogger(Rhat.class.getName());

    public Rhat() {

    }

    public static void main(String[] args) {
        Rhat rhat = new Rhat();
        try {
            AnalysisTask requestedTask = rhat.parseArguments(args);
            rhat.startTask(requestedTask);
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private AnalysisTask parseArguments(String[] args) {
        String[] taskArgs = Arrays.copyOfRange(args, 1, args.length);
        switch (args[0]) {
            case "segmentation":
                LOG.log(Level.INFO, "Requested a segmentation task");
                AnalysisTask segmenter = new BroadcastSegmenter(taskArgs);
                return segmenter;

            case "ambience":
                LOG.log(Level.INFO, "Requested an ambience detection task");
                AnalysisTask ambienceDetector = new AmbientDetector(taskArgs);
                return ambienceDetector;

            default:
                LOG.log(Level.SEVERE, "Requested an unrecognized task");
                throw new IllegalArgumentException("Requested an unrecognized task");
        }
    }

    private void startTask(AnalysisTask requestedTask) {
        requestedTask.run();
    }

}
