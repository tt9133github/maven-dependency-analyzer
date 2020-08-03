package org.apache.maven.shared.dependency.analyzer;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.maven.artifact.Artifact;

import junit.framework.TestCase;

/**
 * Tests <code>ProjectDependencyAnalysis</code>.
 * 
 * @author <a href="mailto:markhobson@gmail.com">Mark Hobson</a>
 * @version $Id$
 * @see ProjectDependencyAnalysis
 */
public class ProjectDependencyAnalysisTest
    extends TestCase
{
    // tests ------------------------------------------------------------------

    public void testConstructor()
    {
        Set<Artifact> usedDeclaredArtifacts = new HashSet<Artifact>();
        Map<Artifact, Set<DependencyUsage>> usedDeclaredArtifactToUsageMap = new HashMap<Artifact, Set<DependencyUsage>>();
        Set<Artifact> usedUndeclaredArtifacts = new HashSet<Artifact>();
        Map<Artifact, Set<DependencyUsage>> usedUndeclaredArtifactToUsageMap = new HashMap<Artifact, Set<DependencyUsage>>();
        Set<Artifact> unusedDeclaredArtifacts = new HashSet<Artifact>();
        Set<Artifact> testArtifactsWithNonTestScope = new HashSet<Artifact>();

        ProjectDependencyAnalysis analysis =
            new ProjectDependencyAnalysis( usedDeclaredArtifacts, usedUndeclaredArtifacts, unusedDeclaredArtifacts,
                    testArtifactsWithNonTestScope);

        assertEquals( usedDeclaredArtifacts, analysis.getUsedDeclaredArtifacts() );
        assertEquals( usedDeclaredArtifactToUsageMap, analysis.getUsedDeclaredArtifactToUsageMap() );
        assertEquals( usedUndeclaredArtifacts, analysis.getUsedUndeclaredArtifacts() );
        assertEquals( usedUndeclaredArtifactToUsageMap, analysis.getUsedUndeclaredArtifactToUsageMap() );
        assertEquals( unusedDeclaredArtifacts, analysis.getUnusedDeclaredArtifacts() );
    }
}
