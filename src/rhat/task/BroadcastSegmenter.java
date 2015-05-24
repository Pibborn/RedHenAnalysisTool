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
package rhat.task;

import be.panako.cli.Panako;
import java.util.logging.Logger;
import rhat.cli.AnalysisTask;

/**
 *
 * @author mattia
 */
public class BroadcastSegmenter extends AnalysisTask {
    private static final Logger log = Logger.getLogger(AnalysisTask.class.getName());

    private String[] args;

    public BroadcastSegmenter(String[] args) {
        this.args = args;
    }

    public void run() {
        Panako panako = new Panako();
        panako.main(args);
    }

}
