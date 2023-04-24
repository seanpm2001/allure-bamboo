/*
 *  Copyright 2016-2023 Qameta Software OÜ
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.qameta.allure.bamboo.util;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public final class FileStringReplacer {

    private FileStringReplacer() {
        // do not instantiate
    }

    public static void replaceInFile(final Path filePath,
                                     final String oldString,
                                     final String newString) throws IOException {
        String content = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);
        content = content.replaceAll(oldString, newString);
        Files.write(filePath, content.getBytes(StandardCharsets.UTF_8));
    }

    public static void replaceInFile(final Path filePath,
                                     final @NotNull Pattern pattern,
                                     final String newString) throws IOException {
        String content = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);
        content = pattern.matcher(content).replaceAll(newString);
        Files.write(filePath, content.getBytes(StandardCharsets.UTF_8));
    }

}
