package io.cap;

/**
 * Naming heirarchy for objects.
 */
public interface Named
{
    /**
     * Name of the parent to this object.
     * @return parent name
     */
    String getParentName();

    /**
     * Set the name of the parent to this object.
     * @param name parent name
     */
    void setParentName( String name );

    /**
     * Name of this object.
     * @return name
     */
    String getName();

    /**
     * Set the name of this object.
     * @param name object name
     */
    void setName( String name );

    /**
     * Return the qualified name as
     * parent.name
     * @return fully qualified name.
     */
    String getFullyQualifiedName();
}
