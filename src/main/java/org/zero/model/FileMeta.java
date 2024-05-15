package org.zero.model;

import java.io.Serializable;

public record FileMeta(
        boolean isExists,
        String path,
        boolean isDirectory,
        boolean isHidden,
        String creationTime,
        String lastModifiedTime,
        String lastAccessTime,
        long size
        ) implements Serializable {
}
