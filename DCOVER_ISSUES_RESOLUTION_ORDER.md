# Diffblue Cover Issues - Suggested Resolution Order

This document provides a recommended order for resolving Diffblue Cover issues using `dcover issues --prompts --auto-apply-fixes-with-llm`.

## Summary Statistics

- **Total Issues**: 32
- **Affected Methods**: 54

## Issue Breakdown by Type

| Issue Code | Description | Count | Methods |
|------------|-------------|-------|---------|
| R083 | Can't find a suitable constructor | 3 | 8 |
| R013 | No inputs found that don't throw a trivial exception | 19 | 19 |
| R002 | Missing observers | 4 | 9 |
| R081 | Exception in arrange section | 4 | 12 |
| R011 | Sandboxing policy violation | 1 | 5 |
| R031 | Method may be time-sensitive | 1 | 1 |

---

## Recommended Resolution Order

### **Priority 1: Foundation Issues** (Resolve these first - they unblock other tests)

#### 1. R083 - Can't find a suitable constructor (3 issues, 8 methods)

**Affected Classes:**
- `EntityJsonContext` (6 methods)
  - `getInstanceJsonNode()`
  - `getInstanceSource()`
  - `getSchemaJsonNode()`
  - `getSchemaSource()`
  - `getValidationResult()`
  - `withValidationResult(Object)`

- `EntityJsonURIDownloader` (2 methods)
  - `getInstance()`
  - `fetch(URI)`

**Rationale**: Constructor issues prevent instance creation, which is foundational for all tests. Fix these first.

**Command**:
```bash
dcover issues --prompts --auto-apply-fixes-with-llm --issue-code R083
```

---

#### 2. R081 - Exception in arrange section (4 issues, 12 methods)

**Affected Classes:**
- `EntityJson` (3 methods)
  - `getChildren()`
  - `getContext()`
  - `toString()`
  - Exception: `NullPointerException` at `EntityJson.<init>(EntityJson.java:78)`

- `StructuredObject` (7 methods)
  - `getContext()`
  - `getIdList()`
  - `getMajorVersion()`
  - `getMinorVersion()`
  - `getType()`
  - `getVersion()`
  - `toString()`
  - Exception: `NullPointerException` at `StructuredObject.<init>(StructuredObject.java:81)`

- `StructuredObjectId` (1 method)
  - `toString()`
  - Exception: `NullPointerException` at `StructuredObjectId.<init>(StructuredObjectId.java:41)`

- `Chime` (1 method)
  - `getPresentationMLTag()`
  - Exception: `InvalidInputException: Element "chime" has to be the only element in the message.`

**Rationale**: These prevent basic test setup. Resolving them may also help with R013 issues.

**Command**:
```bash
dcover issues --prompts --auto-apply-fixes-with-llm --issue-code R081
```

---

#### 3. R011 - Sandboxing policy violation (1 issue, 5 methods)

**Affected Classes:**
- `EntityJsonParser` (5 methods)
  - `<init>(boolean)`
  - `parseEntityJson(Object, ObjectNode)`
  - `parseStructuredObject(Object, ObjectNode)`
  - `validate(URL, Object, Reader)`
  - `validate(URL, URL)`

**Issue**: Code attempts to access the network, which is blocked by Diffblue Cover's sandboxing policy.

**Rationale**: This is a configuration/approach issue affecting multiple methods. One fix resolves all 5 methods.

**Command**:
```bash
dcover issues --prompts --auto-apply-fixes-with-llm --issue-code R011
```

---

### **Priority 2: Systematic Factory Issues** (Work through these methodically)

#### 4. R013 - No inputs found (NullPointerException cases) (9 issues)

**Affected Methods:**
- `StructuredObject.validate(EntityJsonParser)`
  - NPE at `StructuredObject.<init>(StructuredObject.java:81)`

- `MessageMLParser.getAllSplittableAttributes(String)`
  - NPE at `MessageMLParser.java:693`

- `MessageMLParser.getAllSplittableValues(String)`
  - NPE at `MessageMLParser.java:706`

- `MessageMLParser.getSplittableAttributes(String, Class)`
  - NPE at `MessageMLParser.java:680`

- `MessageMLParser.loadElementId(String)`
  - NPE at `MessageMLParser.java:668`

- `Element.assertAttributeIsBoolean(String)`
  - NPE at `Element.assertAttributeValue(Element.java:551)`

- `Element.assertAttributeValue(String, Collection)`
  - NPE at `Element.assertAttributeValue(Element.java:551)`

- `Mention.asText()`
  - NPE at `Mention.asText(Mention.java:168)`

- `TextNode.<init>(Element, Text)`
  - NPE at `TextNode.<init>(TextNode.java:34)`

- `TextNode.buildText(Text)`
  - NPE at `TextNode.buildText(TextNode.java:60)`

**Rationale**: NPEs are typically the easiest R013 issues to fix with factories. Start here.

**Command**:
```bash
# Process these individually or in batches
dcover issues --prompts --auto-apply-fixes-with-llm --limit 5 --skip 0
```

---

#### 5. R013 - No inputs found (IndexOutOfBoundsException cases) (3 issues)

**Affected Methods:**
- `EntityJson.get(int)`
  - `IndexOutOfBoundsException: Index 1 out of bounds for length 0`

- `TextArea.getElementInitialValue()`
  - `IndexOutOfBoundsException: Index 0 out of bounds for length 0`

- `TextField.getElementInitialValue()`
  - `IndexOutOfBoundsException: Index 0 out of bounds for length 0`

**Rationale**: These typically need factories that create properly populated collections.

---

#### 6. R013 - No inputs found (DOM-related exceptions) (3 issues)

**Affected Methods:**
- `DateSelector.buildElementFromDiv(MessageMLParser, Element)`
  - `IIODOMException: No such attribute!`

- `GroupedElement.buildElementAttrFromInputTag(MessageMLParser, Node)`
  - `DOMException: This NamedNodeMap is read-only!`

- `SplittableElement.fillAttributes(MessageMLParser, Node)` (2 overloads)
  - `DOMException: Method not supported`

**Rationale**: DOM issues may need special handling with proper document creation.

---

#### 7. R013 - No inputs found (other exceptions) (2 issues)

**Affected Methods:**
- `MessageMLContext.parseMessageML(String, String, String)`
  - `InvalidInputException: Invalid messageML: The markup in the document preceding the root element must be well-formed.`

- `XmlPrintStream.closeElement()`
  - `NoSuchElementException` at `LinkedList.removeFirst()`

---

### **Priority 3: Design Decisions** (Address last)

#### 8. R002 - Missing observers (4 issues, 9 methods)

**Affected Classes:**
- `NoOpDataProvider` (2 methods)
  - `<init>()`
  - `validateURI(URI)`

- `NoOpEntityResolver` (1 method)
  - `<init>()`

- `NullErrorHandler` (4 methods)
  - `<init>()`
  - `error(SAXParseException)`
  - `fatalError(SAXParseException)`
  - `warning(SAXParseException)`

- `NullDataProvider` (2 methods)
  - `<init>()`
  - `validateURI(URI)`

**Issue**: No fields to assert on - these are no-op implementations by design.

**Rationale**: These are no-op/null implementations by design. May require design decisions about testability or may not need testing.

**Command**:
```bash
dcover issues --prompts --auto-apply-fixes-with-llm --issue-code R002
```

---

#### 9. R031 - Method may be time-sensitive (1 issue, 1 method)

**Affected Methods:**
- `ShortID.generate()`

**Issue**: Method generates time-based values. Tests don't pass when run at alternate dates/times.

**Solution**: Refactor to accept a `java.time.Clock` parameter for testability.

**Rationale**: Requires refactoring to accept a Clock parameter. Lower impact, handle last.

**Command**:
```bash
dcover issues --prompts --auto-apply-fixes-with-llm --issue-code R031
```

---

## Execution Strategy

### Recommended Approach

1. **Start with foundational issues** (R083, R081, R011) as they unlock other tests
2. **Work through R013 systematically** by exception type:
   - NullPointerException (most common, usually straightforward)
   - IndexOutOfBoundsException (need proper collection initialization)
   - DOM exceptions (may need special handling)
   - Other exceptions (case-by-case)
3. **Address design issues last** (R002, R031) as they may require architectural decisions

### Batch Processing Commands

```bash
# Step 1: Constructor issues
dcover issues --prompts --auto-apply-fixes-with-llm --issue-code R083

# Step 2: Arrange exceptions
dcover issues --prompts --auto-apply-fixes-with-llm --issue-code R081

# Step 3: Sandboxing violations
dcover issues --prompts --auto-apply-fixes-with-llm --issue-code R011

# Step 4-7: Factory issues (R013)
# Process in batches to review progress
dcover issues --prompts --auto-apply-fixes-with-llm --issue-code R013 --limit 5 --skip 0
dcover issues --prompts --auto-apply-fixes-with-llm --issue-code R013 --limit 5 --skip 5
# Continue with additional batches...

# Step 8: Missing observers
dcover issues --prompts --auto-apply-fixes-with-llm --issue-code R002

# Step 9: Time-sensitive methods
dcover issues --prompts --auto-apply-fixes-with-llm --issue-code R031
```

### After Each Step

1. Recompile: `mvn install -DskipTests`
2. Rerun `dcover issues` to see progress
3. Review generated factories/changes
4. Run tests to ensure they pass

---

## Notes

- Always recompile after applying fixes: `mvn install -DskipTests`
- Some issues may resolve automatically once foundational issues are fixed
- The LLM may not be able to fix all issues automatically - manual intervention may be needed
- Consider running `dcover test` after major fix batches to verify test generation improves

---

Generated: 2026-01-09
